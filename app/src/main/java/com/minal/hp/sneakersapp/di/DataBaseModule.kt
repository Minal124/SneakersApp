package com.minal.hp.sneakersapp.di

import android.content.Context
import androidx.room.Room
import com.minal.hp.sneakersapp.model.source.local.dao.ISneakersDao
import com.minal.hp.sneakersapp.model.source.local.database.SneakersRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    @Singleton
    fun provideSneakerDao(sneakersRoomDatabase: SneakersRoomDatabase): ISneakersDao {
        return sneakersRoomDatabase.sneakersDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): SneakersRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            SneakersRoomDatabase::class.java,
            "sneaker_db"
        ).build()
    }

}