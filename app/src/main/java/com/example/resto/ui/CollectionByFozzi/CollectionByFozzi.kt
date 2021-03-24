package com.example.resto.ui.CollectionByFozzi

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.resto.R
import com.example.resto.ui.CollectionByFozzi.item.Collections_Item
import com.example.resto.ui.dashboard.DashboardFragmentDirections
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.collections_by_fozzi_item.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.popular_this_week_fragment.*

class CollectionByFozzi : Fragment() {

    companion object {
        fun newInstance() = CollectionByFozzi()
    }

    private lateinit var viewModel: CollectionByFozziViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.popular_this_week_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CollectionByFozziViewModel::class.java)
        // TODO: Use the ViewModel
        initItemCollection()
        setOnClickListener()
    }
    fun initItemCollection(){
        val items= mutableListOf<Collections_Item>()
        (0..9).forEach{
            items.add(Collections_Item())
        }
        collection_by_fossi_item.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)

            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun setOnClickListener(){
        pageTitle.setOnClickListener {
           Navigation.findNavController(it).navigate(CollectionByFozziDirections.actionCollectionByFozziToAsiaRestaurantFragment())
        }
    }

}