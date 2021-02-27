package com.example.resto.ui.recoverpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resto.R
import com.example.resto.ui.phoneverification.VerifyYourPhoneActivity

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var signup : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        signup = findViewById<Button>(R.id.recoverpassword_SendButon)
        signup.setOnClickListener {
            var intent = Intent(this@ForgotPasswordActivity ,VerifyYourPhoneActivity::class.java )
            startActivity(intent)
        }
    }
}