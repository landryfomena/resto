package com.example.resto.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.dashboard.DashboardFragmentDirections
import com.example.resto.ui.home.item.ItemTopCategories
import com.example.resto.ui.home.item.Item_Resto_Extended
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlin.math.round

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
        })
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecycleview()
        initTopCategories()
        setOnClickListener()
        showDialog1(requireView())

    }
    fun initRecycleview(){
        var items= mutableListOf<Item_Resto_Extended>()
        (0..5).forEach{
          items.add(Item_Resto_Extended())
        }
        new_places_container.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun initTopCategories(){
        var items= mutableListOf<ItemTopCategories>()
        (0..5).forEach{
            items.add(ItemTopCategories())
        }
        topCategories.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun setOnClickListener(){
        icon_search.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionNavigationHomeToSearch())
        }
    }
    fun showDialog1(view: View){
        val builder=AlertDialog.Builder(requireContext())
        builder.setTitle("yo man")
        builder.setMessage("trop fort toi")
        builder.show()
    }
}