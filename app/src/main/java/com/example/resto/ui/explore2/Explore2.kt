package com.example.resto.ui.explore2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.explore2.item.ItemCollection
import com.example.resto.ui.explore2.item.ItemPopular
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_explore_2.*

class Explore2 : Fragment() {

    private lateinit var myOrderViewModel: MyOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myOrderViewModel =
            ViewModelProvider(this).get(MyOrderViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_explore_2, container, false)

        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initPopular()
        initCollection()
        setOnClickListener()
    }
    fun setOnClickListener(){
        show2.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(Explore2Directions.actionNavigationDashboardToCollectionByFozzy2())
        }
        main_searchView.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(Explore2Directions.actionNavigationMyOrderToSearch())
        }
    }
    fun initPopular(){
        var items= mutableListOf<ItemPopular>()
        (0..9).forEach{
            items.add(ItemPopular())
        }
        popular_this_week_container.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun initCollection(){
        var items= mutableListOf<ItemCollection>()
        (0..5).forEach{
            items.add(ItemCollection())
        }
        collection_by_fossi.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
}