package com.example.resto.ui.restaurant

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Item_Feature_Boon
import com.example.resto.ui.restaurant.item.Option
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.boon_lay_fragment.feature_collection
import kotlinx.android.synthetic.main.edit_profile_fragment.*
import kotlinx.android.synthetic.main.resto_feature_boon_lay_fragment.*
import kotlinx.android.synthetic.main.resto_feature_boon_lay_fragment.arrowback

class RestoFeatureBoonLayFragment : Fragment() {
    companion object {
        fun newInstance() = RestoFeatureBoonLayFragment()
    }

    private lateinit var viewModel: RestoFeatureBoonLayViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.resto_feature_boon_lay_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RestoFeatureBoonLayViewModel::class.java)
        // TODO: Use the ViewModel
        initFeature()
        setOnClickListener()

    }
    fun initFeature(){
        var items= mutableListOf<Item_Feature_Boon>()
        (0..7).forEach{
            items.add(Item_Feature_Boon())
        }
        feature_collection.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    private fun setOnClickListener() {
        option_popular.setOnClickListener {
            initOption()
            option_popular.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_expand_more_24))
        }
        add_order.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(RestoFeatureBoonLayFragmentDirections.actionRestoFeatureBoonLayFragmentToMyOrderResto())
        }
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }
    fun initOption(){
        var items= mutableListOf<Option>()

        items.add(Option())
        option_collection.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
}