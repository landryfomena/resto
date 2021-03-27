package com.example.resto.ui.registration

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.ui.dashboard.item.ItemPopular
import com.example.resto.ui.registration.Item.alertDialogConfirmP
import com.example.resto.ui.verifyyourphone.VerifyYourPhoneActivity
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.password_confirm_dialog.*
import kotlinx.android.synthetic.main.password_confirm_dialog.view.*
import java.security.AccessController.getContext

class SignupActivity : AppCompatActivity() {
    lateinit var signup : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signup = findViewById<Button>(R.id.registration_button)
        signup.setOnClickListener {
            val intent = Intent(this@SignupActivity , VerifyYourPhoneActivity::class.java )
            startActivity(intent)
        }
    }

    @SuppressLint("ResourceType")
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


    }//12009008607
}