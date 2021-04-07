package com.example.resto.ui.authentification

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.ui.createaccount.CreateAccountActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_authentification.*
import kotlinx.android.synthetic.main.filters_fragment.*


class AuthentificationActivity : AppCompatActivity() {
    lateinit var login:Button
    lateinit var signup:TextView
    lateinit var forgotpass:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)
        login=findViewById<Button>(R.id.login_btn)
        login.setOnClickListener {
            var intent= Intent(this@AuthentificationActivity, MainActivity::class.java)
            startActivity(intent)
        }
        signup=findViewById<TextView>(R.id.sign_up)
        signup.setOnClickListener {
            var intent1= Intent(this@AuthentificationActivity,CreateAccountActivity::class.java)
            startActivity(intent1)
        }
        forgotpass=findViewById<TextView>(R.id.forgot)
        forgotpass.setOnClickListener {
            var intent1= Intent(this@AuthentificationActivity,ForgotPasswordActivity::class.java)
            startActivity(intent1)
        }

    }

}