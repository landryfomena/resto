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
        return inflater.inflate(R.layout.my_order_fragment, container, false)
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
        cardView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
                dialog.dismiss()
                //val show = Toast.makeText(requireContext(), cardView, Toast.LENGTH_SHORT).show
            }
        })
        dialog.show()
    }

}