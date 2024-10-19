package com.x1oto.dionandroid.manualdi.diwithcontainer

import android.app.Application

// Custom Application class that needs to be specified
// in the AndroidManifest.xml file
class MyApplication : Application() {

    // Instance of AppContainer that will be used by all the Activities of the app
    val appContainer = AppContainer()
}