package com.x1oto.dionandroid.manualdi.diwithfactorycontainer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.x1oto.dionandroid.R
import com.x1oto.dionandroid.manualdi.basicdi.LoginViewModel

class LoginDiWithContainerActivity : AppCompatActivity() {

    /**
     * This approach is better than the previous one, but there are still some challenges to consider:
     *
     * You have to manage AppContainer yourself, creating instances for all dependencies by hand.
     *
     * There is still a lot of boilerplate code. You need to create factories or parameters by hand depending on whether you want to reuse an object or not.
     * */

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_with_container)

        val userRepository = (application as MyApplication).appContainer
        loginViewModel = LoginViewModel(userRepository.loginViewModelFactory.create())

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}