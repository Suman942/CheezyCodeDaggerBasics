package com.personal.cheezycodedaggerbasics.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.personal.cheezycodedaggerbasics.db.FakerDB
import com.personal.cheezycodedaggerbasics.models.Products
import com.personal.cheezycodedaggerbasics.networking.ApiInterface
import com.personal.cheezycodedaggerbasics.utils.isNetworkAvailable
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiInterface: ApiInterface,private val fakerDB: FakerDB,private val context: Context){

    private val productsMutableLiveData = MutableLiveData<List<Products>>()
    val productsLiveData: LiveData<List<Products>>
    get() = productsMutableLiveData
    suspend fun getProducts(){
        Log.d("REPOSITORY","17")
        if (isNetworkAvailable(context)) {
            val result = apiInterface.getProducts()
            if (result.isSuccessful && result.body() != null){
                Log.d("REPOSITORY","success")
                fakerDB.getFakerDao().addProducts(result.body()!!)
                productsMutableLiveData.postValue(result.body())
            }
        }
        else {
            Log.d("REPOSITORY","failure")
            productsMutableLiveData.postValue(fakerDB.getFakerDao().getProducts())
        }
    }
}