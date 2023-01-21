package com.minal.hp.sneakersapp.model.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo
import com.minal.hp.sneakersapp.model.source.local.dao.ISneakersDao


@Database(
    entities = [SneakersInfo::class, CartItemInfo::class],
    version = 2,
    exportSchema = false
)
abstract class SneakersRoomDatabase : RoomDatabase() {
    abstract fun sneakersDao(): ISneakersDao
}
