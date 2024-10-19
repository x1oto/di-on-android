package com.x1oto.dionandroid.manualdi.basicdi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.awaitResponse

class LoginViewModel(private val userRepository: UserRepository): ViewModel() {

    private val _localData = MutableLiveData<String>()
    val localData: LiveData<String> get() = _localData

    fun getLocalData() {
        viewModelScope.launch {
           val data = userRepository.getLocalDataSource()
            when(data) {
                is LocalFetchResult.Success -> {
                    _localData.postValue(data.data)
                }
                is LocalFetchResult.Error -> {
                    _localData.postValue(data.error)
                }
            }
        }
    }

    fun getRemoteData(username: String, password: String) {
        viewModelScope.launch {
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val response = userRepository.getRemoteDataSource(username, password)
                handleLoginResponse(response)
            } else {
                val response = userRepository.getRemoteDataSource()
                handleLoginResponse(response)
            }
        }
    }

    private suspend fun handleLoginResponse(response: Call<LoginResponse>) {
        if (response.isExecuted) {

        } else {

        }
    }

}