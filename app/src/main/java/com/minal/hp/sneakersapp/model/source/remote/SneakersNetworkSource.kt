package com.minal.hp.sneakersapp.model.source.remote

import android.content.Context
import com.minal.hp.sneakersapp.model.dto.SneakersDTO
import javax.inject.Inject

class SneakersNetworkSource @Inject constructor(
    private val context: Context
): ISneakersNetworkSource {

    override suspend fun getSneakers(): List<SneakersDTO> {
        return Api.JsonUtil.getSneakersList(context)
    }
}