package com.minal.hp.sneakersapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SneakersAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}