package com.nostereal.universityschedule

import android.content.Context
import com.google.common.truth.Truth.assertThat
import com.nostereal.universityschedule.network.ScheduleService
import com.nostereal.universityschedule.utils.extensions.isNetworkAvailable
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.io.File

class NetworkingTest {
    private val context = mock(Context::class.java)
    private val cacheDir = File("/data/user/0/com.nostereal.universityschedule/cache")

    @Test
    fun requestInOfflineModeShouldReturnCacheRequest() = runBlocking<Unit> {
        `when`(context.isNetworkAvailable).thenReturn(false)
        `when`(context.cacheDir).thenReturn(cacheDir)

        val service = ScheduleService.create(context)
        val response = service.getSchedule("181-721", 0)

        assertThat(response.status).isEqualTo("ok")
        assertThat(response.group.groupName).isEqualTo("181-721")
    }

    @Test
    fun responseStatusIsOKWhenNetwokAvailable() = runBlocking<Unit> {
        `when`(context.isNetworkAvailable).thenReturn(true)
        `when`(context.cacheDir).thenReturn(cacheDir)

        val service = ScheduleService.create(context)
        val response = service.getSchedule("181-721", 0)

        assertThat(response.status).isEqualTo("ok")
        assertThat(response.group.groupName).isEqualTo("181-721")
    }
}