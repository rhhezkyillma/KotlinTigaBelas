package com.example.reezkyillma.kotlintigabelas.di.modules

import com.example.reezkyillma.kotlintigabelas.api.Catalog
import com.example.reezkyillma.kotlintigabelas.repo.CatalogRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module

class RepositoryModule {
    @Provides
    @Singleton
    fun provideCatalogRepo(api: Catalog) : CatalogRepository{
        return CatalogRepository(api)
    }
}