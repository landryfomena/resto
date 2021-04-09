package com.example.resto.ui.recoverpassword

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.resto.R
import com.example.resto.ui.verifyyourphone.VerifyYourPhoneActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.dialog_localisation_fragment.*
import kotlinx.android.synthetic.main.password_confirm_dialog.*
import kotlinx.android.synthetic.main.password_confirm_dialog.view.*

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var send: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        send=findViewById<Button>(R.id.recoverpassword_SendButon)
        send.setOnClickListener {
            val intent= Intent(this@ForgotPasswordActivity, VerifyYourPhoneActivity::class.java)
            startActivity(intent)
        }
    }
}