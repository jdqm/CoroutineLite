package com.jdqm.kotlin.coroutine.sample

import com.jdqm.kotlin.coroutine.launch
import com.jdqm.kotlin.coroutine.log
import kotlin.concurrent.thread
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun main() {

    val job = launch() {
        log(1)
        log(2, hello())
    }

    log(job.isActive)
    job.join()
}

suspend fun hello(): Int = suspendCoroutine { continuation ->
    thread {
        Thread.sleep(1000)
        continuation.resume(10086)
    }
}
