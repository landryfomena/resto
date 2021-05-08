package com.example.resto.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.ui.authentification.AuthentificationActivity

class Welcome : AppCompatActivity() {
    lateinit var contact:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        contact=findViewById<Button>(R.id.contact)
        contact.setOnClickListener {
            var intent= Intent(this@Welcome, AuthentificationActivity::class.java)
            startActivity(intent)
        }
    }
}