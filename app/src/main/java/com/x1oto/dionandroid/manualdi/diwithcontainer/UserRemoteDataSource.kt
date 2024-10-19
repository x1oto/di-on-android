package com.x1oto.dionandroid.manualdi.diwithcontainer

import kotlinx.coroutines.delay
import retrofit2.Call

class UserRemoteDataSource(private val loginService: LoginRetrofitService) {
    suspend fun getRemoteData(username: String, password: String): Call<LoginResponse> {
        delay(500)
        return loginService.loginUser(LoginRequest(username, password))
    }
}