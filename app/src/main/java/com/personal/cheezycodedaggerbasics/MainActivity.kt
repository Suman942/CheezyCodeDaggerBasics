package com.personal.cheezycodedaggerbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.personal.cheezycodedaggerbasics.databinding.ActivityMainBinding
import com.personal.cheezycodedaggerbasics.utils.App
import com.personal.cheezycodedaggerbasics.viewModels.MainViewModel
import com.personal.cheezycodedaggerbasics.viewModels.MainViewModelFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as App).applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        mainViewModel.productsLiveData.observe(this, Observer {
            if (it != null) {
                binding.products.text = it.joinToString { x -> x.title + "\n\n" }
            }
        })
    }
}