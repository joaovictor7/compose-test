package com.br.composetest.infra.repositories

import com.br.commom.domain.extensions.safeCallApi
import com.br.composetest.domain.models.Login
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class UserRepository(
    private val safeAppCallerRepository: SafeApiCallerRepository,
    private val firebaseAuth: FirebaseAuth
) {

    fun login(email: String, password: String): Flow<Login> = flow {
        val result = safeAppCallerRepository.runApi {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
        }
        if (result.isSuccess) {
            emit(Login(email, password))
        } else {
            throw result.exceptionOrNull() ?: Exception()
        }
    }

}