package com.example.resto.ui.authentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resto.R
import com.example.resto.ui.verifyyourphone.VerifyYourPhoneActivity

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var send: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        send=findViewById<Button>(R.id.send_btn)
        send.setOnClickListener {
            val intent= Intent(this@ForgotPasswordActivity, VerifyYourPhoneActivity::class.java)
            startActivity(intent)
        }
    }
}