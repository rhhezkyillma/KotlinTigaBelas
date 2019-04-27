package com.example.reezkyillma.kotlintigabelas.di.modules

import android.app.Application
import dagger.Provides
import dagger.Module
import javax.inject.Singleton

@Module
class AppModule (val  application: Application) {
    @Provides
    @Singleton

    fun providedApplication() : Application {
        return application
    }
}