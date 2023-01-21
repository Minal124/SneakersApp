package com.minal.hp.sneakersapp.model.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CartItem")
data class CartItemInfo(
    @PrimaryKey val id: String,
    @ColumnInfo val name:String,
    @ColumnInfo val shoe:String,
    @ColumnInfo val colorway:String,
    @ColumnInfo val brand:String,
    @ColumnInfo val gender:String,
    @ColumnInfo val releaseDate:String,
    @ColumnInfo val styleId:String,
    @ColumnInfo val title:String,
    @ColumnInfo val year:Int,
    @ColumnInfo val retailPrice:Int,
)