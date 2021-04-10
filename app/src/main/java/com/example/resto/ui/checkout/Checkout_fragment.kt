package com.example.resto.ui.checkout

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.resto.R

class Checkout_fragment : Fragment() {
    lateinit var dialog: Dialog
    lateinit var button: Button
    companion object {
        fun newInstance() = Checkout_fragment()
    }

    private lateinit var viewModel: CheckoutFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.checkout_fragment_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CheckoutFragmentViewModel::class.java)
        // TODO: Use the ViewModel
    }
    private fun openDialogOrder() {
        dialog.setContentView(R.layout.dialog_your_order_is_successfully_fragment)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        button=dialog.findViewById(R.id.order_dialog_button)
        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                dialog.dismiss()
                //val show = Toast.makeText(requireContext(), cardView, Toast.LENGTH_SHORT).show
            }
        })
        dialog.setCanceledOnTouchOutside(false)
        dialog.show()
    }
}
