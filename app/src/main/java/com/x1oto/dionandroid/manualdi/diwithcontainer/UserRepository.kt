package com.x1oto.dionandroid.manualdi.diwithcontainer

import retrofit2.Call

class UserRepository(
    private val userLocalDataSource: UserLocalDataSource,
    private val userRemoteDataSource: UserRemoteDataSource
) {
    suspend fun getLocalDataSource(): LocalFetchResult {
        return userLocalDataSource.getLocalData()
    }

    suspend fun getRemoteDataSource(username: String, password: String): Call<LoginResponse> {
        return userRemoteDataSource.getRemoteData(username, password)
    }
}