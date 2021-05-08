package com.example.resto.ui.restaurant

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Item_Asia_Restaurant
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.asia_restaurant_fragment.*

class AsiaRestaurantFragment : Fragment() {

    companion object {
        fun newInstance() = AsiaRestaurantFragment()
    }

    private lateinit var viewModel: AsiaRestaurantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.asia_restaurant_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AsiaRestaurantViewModel::class.java)
        // TODO: Use the ViewModel
        initRecycleview()
        setOnClickListener()

    }
    private fun setOnClickListener(){
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }
    fun initRecycleview(){
        var items= mutableListOf<Item_Asia_Restaurant>()
        (0..5).forEach{
            items.add(Item_Asia_Restaurant())
        }
        asia_container.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }

}