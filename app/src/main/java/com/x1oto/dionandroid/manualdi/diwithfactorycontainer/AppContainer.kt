package com.x1oto.dionandroid.manualdi.diwithfactorycontainer

import com.x1oto.dionandroid.manualdi.basicdi.LoginRetrofitService
import com.x1oto.dionandroid.manualdi.basicdi.UserLocalDataSource
import com.x1oto.dionandroid.manualdi.basicdi.UserRemoteDataSource
import com.x1oto.dionandroid.manualdi.basicdi.UserRepository
import retrofit2.Retrofit

/**
 * Managing dependencies with a container
 * To solve the issue of reusing objects, you can create your own dependencies container class that you use to get dependencies. All instances provided by this container can be public. In the example, because you only need an instance of UserRepository, you can make its dependencies private with the option of making them public in the future if they need to be provided:
 * */

// Container of objects shared across the whole app
class AppContainer {

    // Since you want to expose userRepository out of the container, you need to satisfy
    // its dependencies as you did before
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com")
        .build()
        .create(LoginRetrofitService::class.java)

    private val remoteDataSource = UserRemoteDataSource(retrofit)
    private val localDataSource = UserLocalDataSource()

    // userRepository is not private; it'll be exposed
    val userRepository = UserRepository(localDataSource, remoteDataSource)
    val loginViewModelFactory = LoginViewModelFactory(userRepository)
}