package com.nostereal.universityschedule.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ScheduleService {

    companion object {
        private const val BASE_URL = "https://rasp.dmami.ru/"

        fun create(): ScheduleService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


            return retrofit.create(ScheduleService::class.java)
        }
    }

    @Headers("referer: https://rasp.dmami.ru")
    @GET("site/group")
    fun getSchedule(
        @Query("group") groupName: String,
        @Query("session") isSession: Int
//        @Header("Cookie") parsedCookie: String
    ): Deferred<ScheduleResponse>

    @GET("site/group")
    fun getCookieScript(
        @Query("group") groupName: String,
        @Query("session") isSession: Int
    ): Deferred<String>
}