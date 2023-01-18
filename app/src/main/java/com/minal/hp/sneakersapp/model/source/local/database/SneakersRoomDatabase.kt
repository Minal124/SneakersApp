package com.minal.hp.sneakersapp.model.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.minal.hp.sneakersapp.model.source.local.Sneakers
import com.minal.hp.sneakersapp.model.source.local.dao.ISneakersDao

//TODO ("Not yet implemented")
@Database(entities = [Sneakers::class], version = 1,exportSchema = false)
abstract class LoanRoomDatabase : RoomDatabase() {
    abstract fun sneakersDao(): ISneakersDao

}
