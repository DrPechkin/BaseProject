package ru.vedernikov.f_debug.network

import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

/**
 * Интерсептор, добавляющий запросам задержку.
 */
class DelayInterceptor(private val requestDelayCallback: () -> Long) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        TimeUnit.MILLISECONDS.sleep(requestDelayCallback())
        return chain.proceed(chain.request())
    }
}