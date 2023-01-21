package com.minal.hp.sneakersapp.model.source.local

import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo
import com.minal.hp.sneakersapp.model.source.local.dao.ISneakersDao
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class SneakersPersistenceSource @Inject constructor(
    private val sneakersDao: ISneakersDao
): ISneakersPersistenceSource {
    override suspend fun saveSneakers(sneakersList: List<SneakersInfo>) =
        sneakersDao.insertSneakers(sneakersList)

    override fun getSneakers(): Flow<List<SneakersInfo>> =
        sneakersDao.getAllSneakers()

    override suspend fun saveCartItem(sneakers: CartItemInfo) =
        sneakersDao.insertCartItem(sneakers)

    override suspend fun deleteCartItem(sneakers: CartItemInfo) {
        sneakersDao.deleteCartItem(sneakers)
    }

    override fun getCartItems(): Flow<List<CartItemInfo>> =
        sneakersDao.getCartItems()

}