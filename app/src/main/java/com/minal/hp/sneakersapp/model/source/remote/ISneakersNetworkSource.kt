package com.minal.hp.sneakersapp.model.source.remote

import com.minal.hp.sneakersapp.model.dto.SneakersDTO

interface ISneakersNetworkSource {
    suspend fun  getSneakers(): List<SneakersDTO>
}