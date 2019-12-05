package com.nostereal.universityschedule.network

import android.content.Context
import android.util.Log
import com.nostereal.universityschedule.data.ScheduleResponse
import com.nostereal.universityschedule.utils.extensions.isNetworkAvailable
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ScheduleService {

    companion object {
        private const val BASE_URL = "https://rasp.dmami.ru/"

        fun create(context: Context): ScheduleService {
            val loggingInterceptor =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val cacheSize: Long = (3 * 1024 * 1024).toLong()
            val cache = Cache(context.cacheDir, cacheSize)


            val okHttpClient = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor { chain ->
                    var request = chain.request()

                    request = if (context.isNetworkAvailable) {
                        Log.d("M_ScheduleService", "Network is available, so we're making new request")
                        request.newBuilder()
                            .header(
                                "Cache-Control",
                                "public, max-age=${5}"
                            )
                            .build()
                    } else {
                        Log.d("M_ScheduleService", "Network isn't available. We're using cache...")
                        request.newBuilder()
                            .header(
                                "Cache-Control",
                                "public, only-if-cached, max-stale=${60 * 60 * 24 * 7}"
                            )
                            .build()
                    }

                    chain.proceed(request)
                }
                .addInterceptor(loggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

            return retrofit.create(ScheduleService::class.java)
        }
    }

    @Headers("referer: https://rasp.dmami.ru")
    @GET("site/group")
    suspend fun getSchedule(
        @Query("group") groupName: String,
        @Query("session") isSession: Int
    ): ScheduleResponse
}