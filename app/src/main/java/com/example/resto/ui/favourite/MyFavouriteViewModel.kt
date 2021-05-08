package com.example.resto.ui.favourite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyFavouriteViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is favourite Fragment"
    }
    val text: LiveData<String> = _text
}