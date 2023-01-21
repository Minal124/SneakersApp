package com.minal.hp.sneakersapp.model.source.local

import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo
import kotlinx.coroutines.flow.Flow

interface ISneakersPersistenceSource {
    suspend fun saveSneakers(sneakersList: List<SneakersInfo>)
    fun getSneakers(): Flow<List<SneakersInfo>>

    suspend fun saveCartItem(sneakers: CartItemInfo)
    suspend fun deleteCartItem(sneakers: CartItemInfo)
    fun getCartItems(): Flow<List<CartItemInfo>>
}