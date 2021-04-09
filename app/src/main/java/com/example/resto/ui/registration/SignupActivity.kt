package com.example.resto.ui.registration

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.resto.R
import com.example.resto.ui.verifyyourphone.VerifyYourPhoneActivity
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_secondexplorer.*
import kotlinx.android.synthetic.main.password_confirm_dialog.*
import kotlinx.android.synthetic.main.password_confirm_dialog.view.*

class SignupActivity : AppCompatActivity() {
    lateinit var signup : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()
        signup = findViewById<Button>(R.id.registration_button)
        signup.setOnClickListener {
            val intent = Intent(this@SignupActivity , VerifyYourPhoneActivity::class.java )
            startActivity(intent)
        }
    }

   /* @SuppressLint("ResourceType")
    fun showDialog(view: View?){

        //val mDialogView = LayoutInflater.from(this).inflate(R.layout.password_confirm_dialog,null)
            val builder = AlertDialog.Builder(this)
                //.setView(mDialogView)
                .setView(R.layout.password_confirm_dialog)
                .show()
            builder.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
            //val mAlertDialog = builder.show()
           builder.dialog_button.setOnClickListener { builder.dismiss() }
        builder.setCanceledOnTouchOutside(false)


    }*/
}