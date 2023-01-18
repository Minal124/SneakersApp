package com.minal.hp.sneakersapp.di

import android.app.Application
import android.content.Context
import com.minal.hp.sneakersapp.model.repository.ISneakersRepository
import com.minal.hp.sneakersapp.model.repository.SneakersRepository
import com.minal.hp.sneakersapp.model.source.local.ISneakersPersistenceSource
import com.minal.hp.sneakersapp.model.source.local.SneakersPersistenceSource
import com.minal.hp.sneakersapp.model.source.local.dao.ISneakersDao
import com.minal.hp.sneakersapp.model.source.remote.ISneakersNetworkSource
import com.minal.hp.sneakersapp.model.source.remote.SneakersNetworkSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun getSneakersRepository(source: SneakersRepository): ISneakersRepository

    @Binds
    @Singleton
    abstract fun getSneakersNetworkSource(source: SneakersNetworkSource): ISneakersNetworkSource

    @Binds
    @Singleton
    abstract fun getSneakersPersistenceSource(source: SneakersPersistenceSource): ISneakersPersistenceSource

    companion object {
        @Singleton
        @Provides
        fun provideContext(application: Application): Context
                = application.applicationContext
    }
}