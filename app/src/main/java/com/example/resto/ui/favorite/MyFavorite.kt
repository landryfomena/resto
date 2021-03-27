package com.example.resto.ui.favorite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Item_Asia_Restaurant
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.asia_restaurant_fragment.*
import kotlinx.android.synthetic.main.my_favorite_fragment.*

class MyFavorite : Fragment() {

    companion object {
        fun newInstance() = MyFavorite()
    }

    private lateinit var viewModel: MyFavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.my_favorite_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyFavoriteViewModel::class.java)
        // TODO: Use the ViewModel
        initRecycleview()
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