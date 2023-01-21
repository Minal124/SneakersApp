package com.minal.hp.sneakersapp.model.datamodel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.minal.hp.sneakersapp.model.dto.SneakersDTO

@Entity(tableName = "Sneakers")
data class SneakersInfo(
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

fun SneakersDTO.toSneakersData() : SneakersInfo {

    return SneakersInfo(
        id = this.id,
        brand= this.brand,
        colorway= this.colorway,
        gender= this.gender,
        releaseDate= this.releaseDate,
        retailPrice = this.retailPrice,
        styleId= this.styleId,
        shoe= this.shoe,
        name= this.name,
        title= this.title,
        year= this.year
    )
}
