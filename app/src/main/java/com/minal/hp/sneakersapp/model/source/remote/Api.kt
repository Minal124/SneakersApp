package com.minal.hp.sneakersapp.model.source.remote

import android.content.Context
import com.minal.hp.sneakersapp.model.dto.SneakersDTO
import com.minal.hp.sneakersapp.util.readAssetsFile
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class Api {
    object JsonUtil {
        fun getSneakersList(context: Context): List<SneakersDTO> {
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val listType =
                Types.newParameterizedType(List::class.java, SneakersDTO::class.java)
            val adapter: JsonAdapter<List<SneakersDTO>> = moshi.adapter(listType)
            val json = context.assets.readAssetsFile("sneakers_list.json")
            return adapter.fromJson(json) ?: emptyList()
        }
    }
}