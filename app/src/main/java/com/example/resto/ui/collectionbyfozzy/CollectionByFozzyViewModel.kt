package com.example.resto.ui.collectionbyfozzy

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resto.models.NicePlace

class CollectionByFozzyViewModel : ViewModel() {
    var newColllection = MutableLiveData<List<NicePlace>>().apply {
        value = mutableListOf()
    }
    fun setCollectionByFozzy() {
        var dataSet = mutableSetOf<NicePlace>()
        dataSet.add(NicePlace(1, "Andy & Cindy s Diner"))
        dataSet.add(NicePlace(2, "Chocolat nice place"))
        dataSet.add(NicePlace(3, "Tiong Bahru Bakery"))
        newColllection.value = dataSet.toList()
    }
    // TODO: Implement the ViewModel
}