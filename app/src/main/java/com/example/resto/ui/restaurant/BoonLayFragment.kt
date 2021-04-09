package com.example.resto.ui.restaurant

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resto.R
import com.example.resto.ui.restaurant.item.Item_Feature_Boon
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.boon_lay_fragment.*
import kotlinx.android.synthetic.main.password_confirm_dialog.*

class BoonLayFragment : Fragment() {

//    companion object {
//        fun newInstance() = BoonLayFragment()
//    }

    private lateinit var viewModel: BoonLayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.boon_lay_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BoonLayViewModel::class.java)
        initFeature_item()
        setOnclickListener()
    }
    fun setOnclickListener(){
        feature.setOnClickListener{
            Navigation.findNavController(it)
                .navigate(BoonLayFragmentDirections.actionBoonLayFragmentToChocolatSpiceRestaurant())
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
    }/*
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