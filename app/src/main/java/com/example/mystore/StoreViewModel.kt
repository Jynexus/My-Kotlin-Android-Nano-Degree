package com.example.mystore

import androidx.lifecycle.ViewModel

class StoreViewModel : ViewModel() {
    public  var items  = mutableListOf<NewItem>()

}