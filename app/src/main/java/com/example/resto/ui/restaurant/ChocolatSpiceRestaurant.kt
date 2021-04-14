package com.example.resto.ui.restaurant

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Item_Photo
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.chocolat_spice_restaurant_fragment.*
import kotlinx.android.synthetic.main.chocolat_spice_restaurant_fragment.arrowback
import kotlinx.android.synthetic.main.edit_profile_fragment.*

class ChocolatSpiceRestaurant : Fragment() {

    companion object {
        fun newInstance() = ChocolatSpiceRestaurant()
    }

    private lateinit var viewModel: ChocolatSpiceRestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chocolat_spice_restaurant_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChocolatSpiceRestaurantViewModel::class.java)
        // TODO: Use the ViewModel
        initPhoto()
        setOnClickListener()
    }
    private fun setOnClickListener(){
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }
    fun initPhoto(){
        var items= mutableListOf<Item_Photo>()
        (0..5).forEach{
            items.add(Item_Photo())
        }
        photo.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }

}