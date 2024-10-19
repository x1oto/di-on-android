package com.x1oto.dionandroid.manualdi.diwithcontainer

import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitService {
    @POST("login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): retrofit2.Call<LoginResponse>
}

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val userId: Int
)