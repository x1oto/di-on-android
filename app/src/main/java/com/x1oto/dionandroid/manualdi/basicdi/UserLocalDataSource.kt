package com.x1oto.dionandroid.manualdi.basicdi

import kotlinx.coroutines.delay
import kotlin.random.Random

class UserLocalDataSource {

    suspend fun getLocalData(): LocalFetchResult {
        delay(500)
        return if (Random.nextInt(0, 100) in 0..70) {
            LocalFetchResult.Success("Some local data!")
        } else {
            LocalFetchResult.Error("Number mismatch!")
        }
    }
}

sealed class LocalFetchResult {
    class Success(val data: String) : LocalFetchResult()
    class Error(val error: String) : LocalFetchResult()
}