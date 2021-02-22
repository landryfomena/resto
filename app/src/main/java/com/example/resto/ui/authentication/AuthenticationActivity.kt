package com.example.resto.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.resto.MainActivity
import com.example.resto.R

class AuthenticationActivity : AppCompatActivity() {
    lateinit var button: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        button = findViewById<TextView>(R.id.button_login)
        button.setOnClickListener {
            var intent = Intent(this@AuthenticationActivity, MainActivity::class.java)
            startActivity(intent)
        }

    }
}