package com.minal.hp.sneakersapp.model.repository

import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo
import kotlinx.coroutines.flow.Flow

interface ISneakersRepository {

    suspend fun fetchAndUpdateSneakers()
    fun getSneakers() : Flow<List<SneakersInfo>>

    fun getCartItems() : Flow<List<CartItemInfo>>
    suspend fun saveCartItem(cartItem: CartItemInfo)
    suspend fun deleteCartItem(cartItem: CartItemInfo)

}