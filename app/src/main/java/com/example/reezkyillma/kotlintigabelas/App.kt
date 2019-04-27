package com.example.reezkyillma.kotlintigabelas

import android.app.Application
import com.example.reezkyillma.kotlintigabelas.di.AppComponent

class App : Application() {
    companion object {
        @JvmStatic lateinit var appcomponent : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appcomponent = AppComponent.create(this, "https://api.bol.com/")
    }
}