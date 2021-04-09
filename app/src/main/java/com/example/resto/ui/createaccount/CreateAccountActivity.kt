package com.example.resto.ui.createaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resto.MainActivity
import com.example.resto.R

class CreateAccountActivity : AppCompatActivity() {
    lateinit var sign_up: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        sign_up=findViewById<Button>(R.id.signup_btn)
        sign_up.setOnClickListener {
            var intent= Intent(this@CreateAccountActivity, MainActivity::class.java)
            startActivity(intent)
        }
    }
}