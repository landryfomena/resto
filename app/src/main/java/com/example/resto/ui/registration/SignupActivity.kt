package com.example.resto.ui.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resto.MainActivity
import com.example.resto.R

class SignupActivity : AppCompatActivity() {
    lateinit var signup : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        signup = findViewById<Button>(R.id.registration_button)
        signup.setOnClickListener {
            val intent = Intent(this@SignupActivity , MainActivity::class.java )
            startActivity(intent)
        }
    }
}