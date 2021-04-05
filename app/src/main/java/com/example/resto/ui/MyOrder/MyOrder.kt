package com.example.resto.ui.MyOrder

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.resto.R

class MyOrder : Fragment() {
    lateinit var dialog: Dialog
    lateinit var cardView: CardView

    companion object {
        fun newInstance() = MyOrder()
    }

    private lateinit var viewModel: MyOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_order, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyOrderViewModel::class.java)
        // TODO: Use the ViewModel
        dialog= Dialog(requireContext())
        openDialogOrder()
    }
    private fun openDialogOrder() {
        dialog.setContentView(R.layout.dialog_your_order_is_successfully_fragment)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        cardView=dialog.findViewById(R.id.card)
        cardView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                dialog.dismiss()
                //val show = Toast.makeText(requireContext(), cardView, Toast.LENGTH_SHORT).show
            }
        })
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }

}

/*
class MyOrder : Fragment() {

    private lateinit var dashboardViewModel: MyOrderViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(MyOrderViewModel::class.java)
        val root = inflater.inflate(R.layout.my_order, container, false)

        return root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var items=ItemPopular()
        initPopular()
        initCollection()
        setOnClickListener()
    }
    fun setOnClickListener(){
        show1.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(DashboardFragmentDirections.actionNavigationDashboardToRestoFeatureBoonLayFragment())
        }
        show2.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(DashboardFragmentDirections.actionNavigationDashboardToCollectionByFozzi2())
        }/*
        search_icon.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(DashboardFragmentDirections.actionNavigationDashboardToSearch())
        }*/
        show2.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(DashboardFragmentDirections.actionNavigationDashboardToRestoFeatureBoonLayFragment())
        }
    }
    fun initPopular(){
        var items= mutableListOf<ItemPopular>()
        (0..9).forEach{
            items.add(ItemPopular())
        }
        popular_this_week_container.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.VERTICAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
    fun initCollection(){
        var items= mutableListOf<ItemCollection>()
        (0..5).forEach{
            items.add(ItemCollection())
        }
        collection_by_fossi.apply {
            layoutManager = LinearLayoutManager(requireContext(),
                LinearLayoutManager.HORIZONTAL,false)
            adapter = GroupAdapter<ViewHolder>().apply{
                add(Section(items))
            }
        }
    }
}
*/