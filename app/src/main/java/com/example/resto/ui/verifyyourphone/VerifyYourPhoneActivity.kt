package com.example.resto.ui.verifyyourphone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resto.R
import com.example.resto.ui.phoneVerification.PhoneVerificationActivity
import kotlinx.android.synthetic.main.activity_forgot_password.*
import kotlinx.android.synthetic.main.activity_verify_yourphone.*
import kotlinx.android.synthetic.main.password_confirm_dialog.view.*

class VerifyYourPhoneActivity : AppCompatActivity() {
    lateinit var next:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_yourphone)
        next=findViewById<Button>(R.id.phoneverifiction_button)
        next.setOnClickListener {
            val intent= Intent(this@VerifyYourPhoneActivity, PhoneVerificationActivity::class.java)
            startActivity(intent)
        }
    }

}