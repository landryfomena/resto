package com.example.resto.ui.restaurant

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Option
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.boon_lay_fragment.*
import kotlinx.android.synthetic.main.boon_lay_fragment.dooble_arrow
import kotlinx.android.synthetic.main.full_menu_collection.*

class Full_Menu_collection : Fragment() {

    companion object {
        fun newInstance() = Full_Menu_collection()
    }

    private lateinit var viewModel: FullMenuCollectionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.full_menu_collection, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FullMenuCollectionViewModel::class.java)
        // TODO: Use the ViewModel
        setOnClickListener()
    }
    fun setOnClickListener(){
        option_popular.setOnClickListener {
            initOption()
            option_popular.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_expand_more_24))
        }
    }
    fun initOption(){
        var items= mutableListOf<Option>()

        items.add(Option())
        option_collection_full.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }

    }
}