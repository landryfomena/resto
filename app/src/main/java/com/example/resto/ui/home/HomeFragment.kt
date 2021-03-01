package com.example.resto.ui.home

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.home.Items.ItemRestoExtended
import com.example.resto.ui.home.Items.ItemTopCategoris
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Item
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment() : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initNewPlaces()
        initTopCategoris()
    }

    fun initNewPlaces() {
        var items = mutableListOf<ItemRestoExtended>()
        (0..5).forEach {
            items.add(ItemRestoExtended())
        }
        new_places_container.apply {
            layoutManager= LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(items))
            }
        }
    }
    fun initTopCategoris() {
        var items = mutableListOf<ItemTopCategoris>()

        (0..5).forEach {
            items.add(ItemTopCategoris())
        }
      topCategories.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(items))
            }
        }
    }
    }
