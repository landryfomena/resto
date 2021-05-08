package com.example.resto.ui.verifyyourphone

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.resto.R

class PhoneVerificationActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)
        dialog= Dialog(this)
        openDialogPassword()
    }
    private fun openDialogPassword() {
        dialog.setContentView(R.layout.dialog_pass_fragment)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        textView=dialog.findViewById(R.id.done)
        textView.setOnClickListener(object :View.OnClickListener{
            override fun onClick(view: View) {
                dialog.dismiss()
                //val show = Toast.makeText(requireContext(), cardView, Toast.LENGTH_SHORT).show
            }
        })
        dialog.show()
    }
}