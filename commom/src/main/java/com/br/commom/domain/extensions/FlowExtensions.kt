package com.br.commom.domain.extensions

import kotlinx.coroutines.flow.FlowCollector

suspend fun <T> FlowCollector<T>.safeCallApi(call: suspend () -> T): Result<T> {
    return runCatching {
        call.invoke()
    }
}