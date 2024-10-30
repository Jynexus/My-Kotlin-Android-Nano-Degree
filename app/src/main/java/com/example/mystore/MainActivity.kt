package com.example.mystore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mystore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var viewModel : StoreViewModel = StoreViewModel()
    private lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StoreViewModel::class.java)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
    }
}