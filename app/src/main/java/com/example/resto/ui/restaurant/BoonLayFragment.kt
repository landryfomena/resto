package com.example.resto.ui.restaurant

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.home.HomeFragmentDirections
import com.example.resto.ui.restaurant.item.Item_Asia_Restaurant
import com.example.resto.ui.restaurant.item.Item_Feature_Boon
import com.example.resto.ui.restaurant.item.Item_Recommend
import com.example.resto.ui.restaurant.item.Item_Search
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.asia_restaurant_fragment.*
import kotlinx.android.synthetic.main.boon_lay_fragment.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
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
        setOnClickListener()
        initFeature_item()
    }
    fun setOnClickListener(){
        myOrder.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(BoonLayFragmentDirections.actionBoonLayFragmentToMyOrder())
        }
    }
    fun initFeature_item(){
        var items= mutableListOf<Item_Feature_Boon>()
        (0..5).forEach{
            items.add(Item_Feature_Boon())
        }
        feature_collection.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
}