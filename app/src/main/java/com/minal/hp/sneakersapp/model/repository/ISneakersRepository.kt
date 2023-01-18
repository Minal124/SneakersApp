package com.minal.hp.sneakersapp.model.repository

import com.minal.hp.sneakersapp.model.dto.SneakersDTO

interface ISneakersRepository {
    suspend fun getSneakers() : List<SneakersDTO>
    //suspend fun fetchAndUpdateSneakers()
}