package com.example.resto.ui.paris_holiday

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resto.R
import com.example.resto.models.NicePlace

class ParisHolidayViewModel : ViewModel() {

    var newPresentation_Item = MutableLiveData<List<NicePlace>>().apply {
        value = mutableListOf()
    }
    fun setPresentationItem() {
        var dataSet = mutableSetOf<NicePlace>()
        dataSet.add(NicePlace(R.drawable.restau_one))
        dataSet.add(NicePlace(R.drawable.restau_two))
        dataSet.add(NicePlace(R.drawable.restau_tree))
        dataSet.add(NicePlace(R.drawable.restau_five))
        dataSet.add(NicePlace(R.drawable.restau_six))
        newPresentation_Item.value = dataSet.toList()
    }
    // TODO: Implement the ViewModel
}