package com.example.reezkyillma.kotlintigabelas.di

import android.app.Application
import android.content.Context
import com.example.reezkyillma.kotlintigabelas.di.modules.ApiModule
import com.example.reezkyillma.kotlintigabelas.di.modules.AppModule
import com.example.reezkyillma.kotlintigabelas.di.modules.NetModule
import com.example.reezkyillma.kotlintigabelas.di.modules.RepositoryModule
import com.example.reezkyillma.kotlintigabelas.repo.CatalogRepository
import com.example.reezkyillma.kotlintigabelas.viewmodel.ProductViewModel
import dagger.Component
//import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = arrayOf(
        AppModule::class,
        NetModule::class,
        RepositoryModule::class,
        ApiModule::class
    )
)

interface AppComponent {

    fun inject (viewModelModule: ProductViewModel)
    fun inject (activity : Context)

    fun provideCatalogRepository() : CatalogRepository

    companion object Factory {
        fun create(app: Application, baseUrl : String) : AppComponent{
            val appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(app))
                .apiModule(ApiModule())
                .netModule(NetModule(baseUrl))
                .repositoryModule(RepositoryModule())
                .build()

            return  appComponent
        }
    }
}