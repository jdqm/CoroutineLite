package com.jdqm.kotlin.coroutine

interface Deferred<T>: Job {

    suspend fun await(): T

}