package com.example.resto.ui.restaurant

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Item_Asia_Restaurant
import com.example.resto.ui.restaurant.item.Item_Recommend
import com.example.resto.ui.restaurant.item.Item_Search
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.asia_restaurant_fragment.*
import kotlinx.android.synthetic.main.search_fragment.*

class BoonLayFragment : Fragment() {

    companion object {
        fun newInstance() = BoonLayFragment()
    }

    private lateinit var viewModel: BoonLayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.boon_lay_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BoonLayViewModel::class.java)
        // TODO: Use the ViewModel

    }

}