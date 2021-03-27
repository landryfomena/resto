package com.example.resto.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.home.item.Item_Resto_Extended
import com.example.resto.ui.notifications.item.Collection_Item
import com.example.resto.ui.restaurant.item.Item_Asia_Restaurant
import com.example.resto.ui.restaurant.item.Item_Feature_Boon
import com.example.resto.ui.restaurant.item.Item_Recommend
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.asia_restaurant_fragment.*
import kotlinx.android.synthetic.main.asia_restaurant_fragment.*
import kotlinx.android.synthetic.main.boon_lay_fragment.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_notifications.*
import kotlinx.android.synthetic.main.my_favorite_fragment.*
import kotlinx.android.synthetic.main.search_fragment.*

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.my_favorite_fragment, container, false)

        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycleview()

    }
    fun initRecycleview(){
        var items= mutableListOf<Item_Asia_Restaurant>()
        (0..3).forEach{
            items.add(Item_Asia_Restaurant())
        }
        favourite_container.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }

}