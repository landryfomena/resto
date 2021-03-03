package com.example.resto.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.notifications.item.Collection_Item
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_notifications.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initItemCollection()
    }
    fun initItemCollection(){
        var items= mutableListOf<Collection_Item>()
        (0..9).forEach{
            items.add(Collection_Item())
        }
       /*  collection_by_fossi_item.setLayoutManager(
            GridLayoutManager(
                this,
                2
            )
        )*/
        collection_by_fossi_item.apply {
            // GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
            layoutManager = LinearLayoutManager(requireContext(), GridLayoutManager.VERTICAL, false)

            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
}