package com.br.composetest.infra.business

import com.br.composetest.domain.models.Login
import com.br.composetest.infra.repositories.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class LoginBusiness(private val userRep: UserRepository) {

//    fun loginIsValid(login: Login): Flow<Boolean> = userRep.login(login.email, login.password).map {
//        it.email == login.email && it.password == login.password
//    }

    fun loginIsValid(login: Login): Flow<Boolean> = flowOf(true)

}