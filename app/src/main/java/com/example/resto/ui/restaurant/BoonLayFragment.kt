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
import com.example.resto.ui.restaurant.item.Item_Feature_Boon
import com.example.resto.ui.restaurant.item.Option
import com.example.resto.ui.restaurant.item.Option_Full_Menu
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.boon_lay_fragment.*
import kotlinx.android.synthetic.main.boon_lay_fragment.arrowback
import kotlinx.android.synthetic.main.boon_lay_fragment.dooble_arrow
import kotlinx.android.synthetic.main.boon_lay_fragment.feature_collection
import kotlinx.android.synthetic.main.boon_lay_fragment.option_collection
import kotlinx.android.synthetic.main.edit_profile_fragment.*
import kotlinx.android.synthetic.main.full_menu_collection.*
import kotlinx.android.synthetic.main.resto_feature_boon_lay_fragment.option_popular

class BoonLayFragment : Fragment() {

    private lateinit var viewModel: BoonLayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.boon_lay_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BoonLayViewModel::class.java)
        initFeature_item()
        setOnClickListener()
    }
    fun setOnClickListener(){
            dooble_arrow.setOnClickListener {
                initOptionMenu()
                dooble_arrow.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_expand_more_24))
            }
//        option_popular.setOnClickListener {
//            initOption()
//            option_popular.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_expand_more_24))
//        }
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }

        feature.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(BoonLayFragmentDirections.actionBoonLayFragmentToRestoFeatureBoonLayFragment())
        }
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
    fun initOptionMenu(){
        var items= mutableListOf<Option_Full_Menu>()

        items.add(Option_Full_Menu())
        option_collection.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
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
/*
    @SuppressLint("ResourceType")
    fun showDialog(view: View?){
        val builder = AlertDialog.Builder(this)
            //.setView(mDialogView)
            .setView(R.layout.dialog_your_order_is_successfully_fragment)
            .show()
        builder.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        //val mAlertDialog = builder.show()
        builder.dialog_button.setOnClickListener { builder.dismiss() }
        builder.setCanceledOnTouchOutside(false)
    }*/
}