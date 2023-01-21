package com.minal.hp.sneakersapp.model.repository

import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo
import com.minal.hp.sneakersapp.model.datamodel.toSneakersData
import com.minal.hp.sneakersapp.model.source.local.ISneakersPersistenceSource
import com.minal.hp.sneakersapp.model.source.remote.ISneakersNetworkSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SneakersRepository @Inject constructor(
    private val localSource: ISneakersPersistenceSource,
    private val remoteSource: ISneakersNetworkSource,
): ISneakersRepository {

    override fun getSneakers(): Flow<List<SneakersInfo>> =
        localSource.getSneakers()

    override suspend fun fetchAndUpdateSneakers() {
        val remoteData = remoteSource.getSneakers().map{
            it.toSneakersData()
        }
        localSource.saveSneakers(remoteData)
    }

    override fun getCartItems(): Flow<List<CartItemInfo>> =
        localSource.getCartItems()

    override suspend fun saveCartItem(cartItem: CartItemInfo) =
        localSource.saveCartItem(cartItem)

    override suspend fun deleteCartItem(cartItem: CartItemInfo) {
        localSource.deleteCartItem(cartItem)
    }

}