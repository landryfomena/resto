package com.example.resto.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Item_Asia_Restaurant
import com.example.resto.ui.restaurant.item.Item_Feature_Boon
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_favourite.*
import kotlinx.android.synthetic.main.fragment_favourite.arrowback
import kotlinx.android.synthetic.main.fragment_favourite.favourite_container
import kotlinx.android.synthetic.main.fragment_favourite.text1

class MyFavouriteFragment : Fragment() {

    private lateinit var myFavouriteViewModel: MyFavouriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myFavouriteViewModel =
                ViewModelProvider(this).get(MyFavouriteViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favourite, container, false)

        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycleviewpPlaces()
        setOnClickListener()
    }
    fun setOnClickListener(){

        food.setOnClickListener{
            initRecycleviewpFood()
            food.setBackground(resources.getDrawable(R.drawable.rounded_shape_cardview_20dp))
            food.setTextColor(resources.getColor(R.color.white))
            places.setBackground(resources.getDrawable(R.drawable.rounded_shape_item_favourite))
            places.setTextColor(resources.getColor(R.color.gris_clear))
        }
        places.setOnClickListener{
            initRecycleviewpPlaces()
            places.setBackground(resources.getDrawable(R.drawable.rounded_shape_cardview_20dp))
            places.setTextColor(resources.getColor(R.color.white))
            food.setBackground(resources.getDrawable(R.drawable.rounded_shape_item_favourite))
            food.setTextColor(resources.getColor(R.color.gris_clear))
        }
        text1.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(MyFavouriteFragmentDirections.actionNavigationFavouriteToChocolatSpiceRestaurant())
        }
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }
    fun initRecycleviewpPlaces(){
        var items= mutableListOf<Item_Asia_Restaurant>()
        (0..5).forEach{
            items.add(Item_Asia_Restaurant())
        }
        favourite_container.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun initRecycleviewpFood(){
        var items= mutableListOf<Item_Feature_Boon>()
        (0..7).forEach{
            items.add(Item_Feature_Boon())
        }
        favourite_container.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }

}