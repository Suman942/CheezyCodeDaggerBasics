package com.personal.cheezycodedaggerbasics.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.personal.cheezycodedaggerbasics.models.Products

@Database(entities = [Products::class], version = 1)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDao() : FakerDAO
}