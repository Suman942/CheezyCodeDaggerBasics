package com.personal.cheezycodedaggerbasics.networking

import com.personal.cheezycodedaggerbasics.models.Products
import retrofit2.Response

import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    suspend fun getProducts() : Response<List<Products>>
}