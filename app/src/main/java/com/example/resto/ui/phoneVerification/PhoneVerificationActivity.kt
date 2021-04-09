package com.example.resto.ui.phoneVerification

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.cardview.widget.CardView
import com.example.resto.R
import kotlinx.android.synthetic.main.activity_phone_verification.*

class PhoneVerificationActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    lateinit var cardView: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)
        supportActionBar?.hide()
       // openDialogpassword()
        otp_input4.setOnClickListener{
            dialog.setContentView(R.layout.dialog_pass_fragment)
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
      //  addEditTextListener()
    }
    private fun openDialogpassword() {
        dialog.setContentView(R.layout.dialog_pass_fragment)
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

    }/*
    private fun addEditTextListener(editText: EditText?, nextEditText: EditText?) {
        editText?.setOnFocusChangeListener { view, focused ->
            if (focused) {
                editText.text=null
            }
        }
        editText?.addTextChangedListener {
            if (editText?.toString().isNoEmpty()){
                if (nextEditText != null) {
                    nextEditText.requestFocus()
                }else{
                    viewModel.confirmCode(
                        binding?.digit1?.text?.toString(),
                        binding?.digit2?.text?.toString(),
                        binding?.digit3?.text?.toString(),
                        binding?.digit4?.text?.toString(),
                    )
                }
            }
        }
    }   
    override fun setupView(){
        addEditTextListener(binding?.digit1?, binding.digit2)
        addEditTextListener(binding?.digit2?, binding.digit3)
        addEditTextListener(binding?.digit3?, binding.digit4)
        addEditTextListener(binding?.digit1?, null)
    }*/
}

