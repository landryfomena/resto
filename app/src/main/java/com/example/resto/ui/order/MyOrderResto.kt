package com.example.resto.ui.order

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.resto.R
import kotlinx.android.synthetic.main.my_order_resto_fragment.*

class MyOrderResto : Fragment() {

    companion object {
        fun newInstance() = MyOrderResto()
    }

    private lateinit var viewModel: MyOrderRestoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.my_order_resto_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyOrderRestoViewModel::class.java)
        setOnClickListener()
    }

    fun setOnClickListener(){
        order_button.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(MyOrderRestoDirections.actionMyOrderRestoToCheckoutFragment())
        }
    }
}