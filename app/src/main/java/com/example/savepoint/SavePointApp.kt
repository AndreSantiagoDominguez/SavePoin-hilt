package com.example.savepoint

import android.app.Application
import com.example.savepoint.core.di.AppContainer

class SavePointApp : Application() {

    lateinit var appContainer: AppContainer
        private set

    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer()
    }
}
