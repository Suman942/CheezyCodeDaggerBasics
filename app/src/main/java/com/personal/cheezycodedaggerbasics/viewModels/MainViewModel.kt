package com.personal.cheezycodedaggerbasics.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.personal.cheezycodedaggerbasics.models.Products
import com.personal.cheezycodedaggerbasics.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {
    val productsLiveData: LiveData<List<Products>>
    get() = repository.productsLiveData

    init {
        viewModelScope.launch { repository.getProducts() }
    }
}