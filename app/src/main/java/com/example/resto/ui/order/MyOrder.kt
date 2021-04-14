package com.example.resto.ui.order

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.resto.R
import kotlinx.android.synthetic.main.edit_profile_fragment.*

class MyOrder : Fragment() {

    companion object {
        fun newInstance() = MyOrder()
    }

    private lateinit var viewModel: MyOrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_order_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyOrderViewModel::class.java)
        // TODO: Use the ViewModel
        setOnClickListener()
    }
    private fun setOnClickListener(){
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
    }

}