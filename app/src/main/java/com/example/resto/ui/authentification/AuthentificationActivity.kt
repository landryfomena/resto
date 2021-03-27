package com.example.resto.ui.authentification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.ui.recoverpassword.ForgotPasswordActivity
import com.example.resto.ui.registration.SignupActivity
import com.example.resto.ui.restaurantDetails.activity_restaurant_details

class AuthentificationActivity : AppCompatActivity() {
    lateinit var login : Button
    //*********************************************************
    lateinit var signup : TextView
    lateinit var recover : TextView
    //*********************************************************
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)
        login = findViewById<Button>(R.id.buttonlogin)
        login.setOnClickListener {
            var intent = Intent(this@AuthentificationActivity ,MainActivity::class.java)
            startActivity(intent)
        }
            //*********************************************************************************
        signup = findViewById<TextView>(R.id.sing_up)
        signup.setOnClickListener {
            var intent = Intent(this@AuthentificationActivity ,SignupActivity::class.java)
            startActivity(intent)
        }
            //********************************************************************
        recover = findViewById<TextView>(R.id.fogotText)
        recover.setOnClickListener {
            var intent = Intent(this@AuthentificationActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
    }
}