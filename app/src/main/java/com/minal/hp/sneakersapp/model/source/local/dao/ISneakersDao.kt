package com.minal.hp.sneakersapp.model.source.local.dao

import androidx.room.*
import com.minal.hp.sneakersapp.model.datamodel.CartItemInfo
import com.minal.hp.sneakersapp.model.datamodel.SneakersInfo

import kotlinx.coroutines.flow.Flow

@Dao
interface ISneakersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSneakers(sneakers: List<SneakersInfo>)

    @Query("SELECT * FROM Sneakers")
    fun getAllSneakers(): Flow<List<SneakersInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(sneakers: CartItemInfo)

    @Delete
    suspend fun deleteCartItem(sneakers: CartItemInfo)

    @Query("SELECT * FROM CartItem")
    fun getCartItems(): Flow<List<CartItemInfo>>

}