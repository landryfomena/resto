package com.example.resto.ui.collectionbyfozzy

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.resto.R
import com.example.resto.ui.collectionbyfozzy.item.Collection_Item
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.collection_by_fozzy_fragment.*
import kotlinx.android.synthetic.main.collection_by_fozzy_fragment.arrowback
import kotlinx.android.synthetic.main.collection_by_fozzy_fragment.pageTitle
import kotlinx.android.synthetic.main.edit_profile_fragment.*

class CollectionByFozzy : Fragment() {

    companion object {
        fun newInstance() = CollectionByFozzy()
    }

    private lateinit var viewModel: CollectionByFozzyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.collection_by_fozzy_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollectionByFozzyViewModel::class.java)
        // TODO: Use the ViewModel
        initItemCollection()
        setOnClickListener()
    }
    fun initItemCollection(){
        val items= mutableListOf<Collection_Item>()
        (0..9).forEach{
            items.add(Collection_Item())
        }
        collection_by_fossi_item.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)

            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun setOnClickListener(){
        text.setOnClickListener {
              Navigation.findNavController(it).navigate(CollectionByFozzyDirections.actionCollectionByFozzy2ToAsiaRestaurantFragment())
        }
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }

}