package com.minal.hp.sneakersapp.model.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//TODO("Not yet implemented")
@Entity
data class Sneakers(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo val name:String
    )