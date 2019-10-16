package com.nostereal.universityschedule.utils

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.CoroutineContext

object DispatcherProvider {

    fun provideUIContext(): CoroutineContext = Main

    fun provideIOContext(): CoroutineContext = IO

}