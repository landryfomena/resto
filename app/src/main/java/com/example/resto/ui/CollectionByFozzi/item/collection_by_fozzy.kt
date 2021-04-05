package com.example.resto.ui.CollectionByFozzi.item

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.resto.R
import com.example.resto.ui.CollectionByFozzi.item.item.Collections_Item
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.collection_by_fozzy_fragment.*

class collection_by_fozzy : Fragment() {

    companion object {
        fun newInstance() = collection_by_fozzy()
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
        initCollectionItem()
    }
    fun initCollectionItem(){
        var items= mutableListOf<Collections_Item>()
        (0..9).forEach{
            items.add(Collections_Item())
        }
        collectionItems.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
}
