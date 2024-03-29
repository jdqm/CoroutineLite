package com.jdqm.kotlin.coroutine

import com.jdqm.kotlin.coroutine.context.CoroutineName
import com.jdqm.kotlin.coroutine.core.StandardCoroutine
import java.util.concurrent.atomic.AtomicInteger
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

private var coroutineIndex = AtomicInteger(0)

fun launch(context: CoroutineContext = EmptyCoroutineContext,
           block: suspend ()-> Unit): Job {
    val completion = StandardCoroutine(newCoroutineContext(context))
    block.startCoroutine(completion)
    return completion
}

fun newCoroutineContext(context: CoroutineContext): CoroutineContext {
    val combined = context + CoroutineName("@coroutine#${coroutineIndex.getAndIncrement()}")
    return combined
//    return if(combined !== Dispatchers.Default && combined[ContinuationInterceptor] == null)
//        combined + Dispatchers.Default else combined
}
