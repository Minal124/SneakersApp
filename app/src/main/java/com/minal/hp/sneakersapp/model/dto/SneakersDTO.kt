package com.minal.hp.sneakersapp.model.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SneakersDTO(
    @Json(name = "id") val id: String,
    @Json(name = "brand") val brand: String,
    @Json(name = "colorway") val colorway: String,
    @Json(name = "gender") val gender: String,
    @Json(name = "media") val media: MediaDTO,
    @Json(name = "releaseDate") val releaseDate: String,
    @Json(name = "retailPrice") val retailPrice: Int,
    @Json(name = "styleId") val styleId: String,
    @Json(name = "shoe") val shoe: String,
    @Json(name = "name") val name: String,
    @Json(name = "title") val title: String,
    @Json(name = "year") val year: Int
)

@JsonClass(generateAdapter = true)
data class MediaDTO(
    @Json(name = "imageUrl") val imageUrl: String,
    @Json(name = "smallImageUrl") val smallImageUrl: String,
    @Json(name = "thumbUrl") val thumbUrl: String
)