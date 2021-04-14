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
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.example.resto.R
import kotlinx.android.synthetic.main.edit_profile_fragment.*

class CheckOut : Fragment() {
    lateinit var dialog: Dialog
    lateinit var cardView: CardView

    companion object {
        fun newInstance() = CheckOut()
    }

    private lateinit var viewModel: CheckOutViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.check_out_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CheckOutViewModel::class.java)
        // TODO: Use the ViewModel
        dialog= Dialog(requireContext())
        openDialogOrder()
        setOnClickListener()
    }
    private fun setOnClickListener(){
        arrowback.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
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