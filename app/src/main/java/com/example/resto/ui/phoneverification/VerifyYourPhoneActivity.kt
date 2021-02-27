package com.example.resto.ui.phoneverification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.ui.otp.PhoneVerificationActivity

class VerifyYourPhoneActivity : AppCompatActivity() {
    lateinit var Next : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_yourphone)
        Next = findViewById<Button>(R.id.phoneverifiction_button)
        Next.setOnClickListener {
            val intent = Intent(this@VerifyYourPhoneActivity, PhoneVerificationActivity::class.java)
            startActivity(intent)
        }
    }
}