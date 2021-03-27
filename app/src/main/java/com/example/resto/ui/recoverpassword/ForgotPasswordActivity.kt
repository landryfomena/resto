package com.example.resto.ui.recoverpassword

import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.example.resto.R
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.dialog_localisation_fragment.*
import kotlinx.android.synthetic.main.password_confirm_dialog.*
import kotlinx.android.synthetic.main.password_confirm_dialog.view.*

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

    }

    fun showDialog(view: View?){
        val builder = AlertDialog.Builder(this)
            //.setView(mDialogView)
            .setView(R.layout.dialog_pass_fragment)
            .show()
        builder.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        //val mAlertDialog = builder.show()
       // builder.card.setOnClickListener { builder.dismiss() }
        builder.setCanceledOnTouchOutside(false)

    }
}