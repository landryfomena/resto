package com.example.resto.ui.popularThisWeek

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.resto.R
import com.example.resto.ui.notifications.item.Collection_Item
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_notifications.*

class popularThisWeek : Fragment() {

    companion object {
        fun newInstance() = popularThisWeek()
    }

    private lateinit var viewModel: PopularThisWeekViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PopularThisWeekViewModel::class.java)

        initItemCollection()
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

}