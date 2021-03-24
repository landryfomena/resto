package com.example.resto.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.dashboard.item.ItemCollection
import com.example.resto.ui.dashboard.item.ItemPopular
import com.example.resto.ui.home.item.ItemTopCategories
import com.example.resto.ui.home.item.Item_Resto_Extended
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var items=ItemPopular()
        initPopular()
        initCollection()
        setOnClickListener()
    }
    fun setOnClickListener(){
        show1.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(DashboardFragmentDirections.actionNavigationDashboardToRestoFeatureBoonLayFragment())
        }
        show2.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(DashboardFragmentDirections.actionNavigationDashboardToCollectionByFozzi2())
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