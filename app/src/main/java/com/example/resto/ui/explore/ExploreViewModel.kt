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
    var recommmended = MutableLiveData<List<NicePlace>>().apply {
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
        dataSet.add(NicePlace(R.drawable.restau_one, "Andy & Cindy s Diner"))
        dataSet.add(NicePlace(R.drawable.restau_tree, "The Garage Bar & Grill"))
        dataSet.add(NicePlace(R.drawable.restau_five, "Tiong Bahru Bakery"))
        dataSet.add(NicePlace(R.drawable.restau_six, "  Bahru Tiong Bakery"))
        newPlaces.value = dataSet.toList()
    }

    fun setRecommendedPlaces() {
        var dataSet = mutableSetOf<NicePlace>()
        dataSet.add(NicePlace(R.drawable.restau_six, "Andy & Cindy s Diner"))
        dataSet.add(NicePlace(R.drawable.restau_one, "The Garage Bar & Grill"))
        dataSet.add(NicePlace(R.drawable.ic_burger, "Burger"))
        dataSet.add(NicePlace(R.drawable.restau_tree, "Tiong Bahru Bakery"))
        dataSet.add(NicePlace(R.drawable.ic_american, "American"))
        dataSet.add(NicePlace(R.drawable.ic_pizza, "Pizza"))
        dataSet.add(NicePlace(R.drawable.restau_two, "Andy & Cindy s Diner"))
        dataSet.add(NicePlace(R.drawable.restau_one, "The Garage Bar & Grill"))
        dataSet.add(NicePlace(R.drawable.ic_pizza, "Tiong Bahru Bakery"))
        recommmended.value = dataSet.toList()
    }


}