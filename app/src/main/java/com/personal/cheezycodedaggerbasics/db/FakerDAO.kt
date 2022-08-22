package com.personal.cheezycodedaggerbasics.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.personal.cheezycodedaggerbasics.models.Products
import kotlinx.coroutines.selects.select

@Dao
interface FakerDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun addProducts(products: List<Products>)

    @Query("SELECT * from Products")
   suspend fun getProducts() : List<Products>
}