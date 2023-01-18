package com.minal.hp.sneakersapp.model.datamodel

import com.minal.hp.sneakersapp.model.dto.SneakersDTO

fun SneakersDTO.toSneakersData() : SneakersData {
    val media = MediaData(
        this.media.imageUrl,
        this.media.smallImageUrl,
        this.media.thumbUrl
    )
    return SneakersData(
        id = this.id,
        brand= this.brand,
        colorway= this.colorway,
        gender= this.gender,
        media = media,
        releaseDate= this.releaseDate,
        retailPrice = this.retailPrice,
        styleId= this.styleId,
        shoe= this.shoe,
        name= this.name,
        title= this.title,
        year= this.year
    )
}

data class SneakersData  (
    val id: String,
    val brand: String,
    val colorway: String,
    val gender: String,
    val media: MediaData,
    val releaseDate: String,
    val retailPrice: Int,
    val styleId: String,
    val shoe: String,
    val name: String,
    val title: String,
    val year: Int,
)

data class MediaData  (
    val imageUrl: String,
    val smallImageUrl: String,
    val thumbUrl: String,
)