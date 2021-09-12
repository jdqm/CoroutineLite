package com.jdqm.kotlin.coroutine.dispatcher


object Dispatchers {
    val Default by lazy {
        DispatcherContext(DefaultDispatcher)
    }
}