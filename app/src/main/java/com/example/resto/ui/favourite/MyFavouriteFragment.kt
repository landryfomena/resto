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
import com.example.resto.ui.myorder.MyOrderFragmentDirections
import com.example.resto.ui.restaurant.item.Item_Asia_Restaurant
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.filters_fragment.*
import kotlinx.android.synthetic.main.fragment_favourite.*
import kotlinx.android.synthetic.main.fragment_my_order.*

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
        initRecycleview()
        setOnClickListener()
    }
    fun setOnClickListener(){
        favourite_container.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(MyFavouriteFragmentDirections.actionNavigationFavouriteToChocolatSpiceRestaurant())
        }

    }
    fun initRecycleview(){
        var items= mutableListOf<Item_Asia_Restaurant>()
        (0..3).forEach{
            items.add(Item_Asia_Restaurant())
        }
        favourite_container.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }

}