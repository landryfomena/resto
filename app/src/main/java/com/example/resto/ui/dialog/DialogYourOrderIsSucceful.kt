package com.example.resto.ui.dialog

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.resto.R

class DialogYourOrderIsSucceful : Fragment() {

    companion object {
        fun newInstance() = DialogYourOrderIsSucceful()
    }

    private lateinit var viewModel: DialogYourOrderIsSuccefulViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.dialog_your_order_is_successfully_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DialogYourOrderIsSuccefulViewModel::class.java)
        // TODO: Use the ViewModel
    }

}