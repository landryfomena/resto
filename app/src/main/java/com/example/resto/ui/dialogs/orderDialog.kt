package com.example.resto.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.resto.R
import com.example.resto.ui.checkout.CheckoutFragmentViewModel

class orderDialog {
     fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_your_order_is_successfully_fragment, container, false)
    }
     fun onActivityCreated(savedInstanceState: Bundle?) {
     }
}