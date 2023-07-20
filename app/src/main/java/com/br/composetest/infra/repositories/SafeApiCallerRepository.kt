package com.br.composetest.infra.repositories

import kotlinx.coroutines.flow.Flow


class SafeApiCallerRepository {

//    suspend fun <T> safeCallApiFlow(flow: Flow<T>, call: suspend () -> T): Result<T> {
//        val result = runApi(call)
//        if (result.isSuccess) {
//            flow.emit(result.getOrNull())
//        } else {
//            throw result.exceptionOrNull() ?: Exception()
//        }
//    }

    suspend fun <T> runApi(call: suspend () -> T): Result<T> {
        return runCatching {
            call.invoke()
        }
    }

}