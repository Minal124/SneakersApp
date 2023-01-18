package com.minal.hp.sneakersapp.model.repository

import com.minal.hp.sneakersapp.model.dto.SneakersDTO
import com.minal.hp.sneakersapp.model.source.local.ISneakersPersistenceSource
import com.minal.hp.sneakersapp.model.source.remote.ISneakersNetworkSource
import javax.inject.Inject

class SneakersRepository @Inject constructor(
    private val localSource: ISneakersPersistenceSource,
    private val remoteSource: ISneakersNetworkSource,
): ISneakersRepository {

    override suspend fun getSneakers(): List<SneakersDTO> {
        return remoteSource.getSneakers()
    }

    //fetch data from remote and save it to db
//    override suspend fun fetchAndUpdateSneakers() {
//        val remoteData = remoteSource.getSneakers()
//        localSource.saveSneakers(remoteData)
//    }

}