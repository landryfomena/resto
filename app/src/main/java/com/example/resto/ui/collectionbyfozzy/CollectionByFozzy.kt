package com.example.resto.ui.collectionbyfozzy

import android.app.Dialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.resto.R
import com.example.resto.models.NicePlace
import com.example.resto.ui.collectionbyfozzy.item.Collection_Item
import com.example.resto.ui.explore.ExploreViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.collection_by_fozzy_fragment.*
import kotlinx.android.synthetic.main.collection_by_fozzy_fragment.arrowback

class CollectionByFozzy : Fragment() {

    lateinit var dialog: Dialog
    lateinit var textView: TextView
    var aCollection_Item = mutableListOf<Collection_Item>()

    companion object {
        fun newInstance() = CollectionByFozzy()
    }

    private lateinit var collectionByFozzyViewModel: CollectionByFozzyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        collectionByFozzyViewModel =
            ViewModelProvider(this).get(CollectionByFozzyViewModel::class.java)
        return inflater.inflate(R.layout.collection_by_fozzy_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
        collectionByFozzyViewModel.apply {
            setCollectionByFozzy()
        }
        observeViewModel()
        setOnClickListener()
    }
    private fun observeViewModel() {
        collectionByFozzyViewModel.newColllection.observe(viewLifecycleOwner, Observer { newCollection ->
            initItemCollection(newCollection)
        })
    }
    private fun initItemCollection(mCollection: List<NicePlace>?) {
        aCollection_Item = mutableListOf()
        mCollection?.forEach { nicePlace ->
            aCollection_Item.add(Collection_Item(nicePlace))
        }

        collection_by_fossi_item.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)

            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(aCollection_Item))
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