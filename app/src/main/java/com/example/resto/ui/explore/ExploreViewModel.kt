package com.example.resto.ui.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resto.R
import com.example.resto.models.NicePlace

class ExploreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is explore Fragment"
    }
    var newPlaces = MutableLiveData<List<NicePlace>>().apply {
        value = mutableListOf()
    }
    var topCategories = MutableLiveData<List<NicePlace>>().apply {
        value = mutableListOf()
    }
    val text: LiveData<String> = _text

    fun setNicePlaces() {
        var dataSet = mutableSetOf<NicePlace>()
        dataSet.add(NicePlace(R.drawable.ic_burger, "Burger"))
        dataSet.add(NicePlace(R.drawable.ic_american, "American"))
        dataSet.add(NicePlace(R.drawable.ic_pizza, "Pizza"))
        dataSet.add(NicePlace(R.drawable.ic_barbecue, "Barbecue"))
        dataSet.add(NicePlace(R.drawable.ic_burger, "Burger"))
        dataSet.add(NicePlace(R.drawable.ic_american, "American"))
        topCategories.value = dataSet.toList()
    }

    fun setNicePlacesNewPlace() {
        var dataSet = mutableSetOf<NicePlace>()
        dataSet.add(NicePlace(1, "Andy & Cindy s Diner"))
        dataSet.add(NicePlace(2, "The Garage Bar & Grill"))
        dataSet.add(NicePlace(3, "Tiong Bahru Bakery"))
        newPlaces.value = dataSet.toList()
    }
}