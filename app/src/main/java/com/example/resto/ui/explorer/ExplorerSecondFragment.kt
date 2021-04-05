package com.example.resto.ui.explorer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.explorer.item.ItemCollection
import com.example.resto.ui.explorer.item.ItemPopular
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_explorer.*
import kotlinx.android.synthetic.main.fragment_secondexplorer.*

class ExplorerSecondFragment : Fragment() {

    private lateinit var explorerSecondViewModel: ExplorerSecondViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        explorerSecondViewModel =
            ViewModelProvider(this).get(ExplorerSecondViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_secondexplorer, container, false)

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var items = ItemPopular()
        initPopular()
        initCollection()
      //setOnClickListener()
    }
/*
    fun setOnClickListener() {
        show1.setOnClickListener {
           Navigation.findNavController(it)
                .navigate(ExplorerSecondFragmentDirections.actionExplorerSecondFragmentToBoonLayFragment())
       }
        search_icon.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExplorerSecondFragmentDirections.actionExplorerSecondFragmentToExplorerFragment())
        }
        show2.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(ExplorerSecondFragmentDirections.actionExplorerSecondFragmentToCollectionByFozzy())
        }
    }
*/
    fun initPopular() {
        var items = mutableListOf<ItemPopular>()
        (0..9).forEach {
            items.add(ItemPopular())
        }
        popular_this_week_container.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL, false)
            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(items))
            }
        }
    }

    fun initCollection() {
        var items = mutableListOf<ItemCollection>()
        (0..5).forEach {
            items.add(ItemCollection())
        }
        collection_by_fossi.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL, false)
            adapter = GroupAdapter<ViewHolder>().apply {
                add(Section(items))
            }
        }
    }
}