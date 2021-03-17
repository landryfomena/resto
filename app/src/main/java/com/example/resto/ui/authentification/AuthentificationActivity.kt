package com.example.resto.ui.authentification

import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter.JoiningType.TRANSPARENT
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.ui.createaccount.CreateAccountActivity
import kotlinx.android.synthetic.main.activity_authentification.*


class AuthentificationActivity : AppCompatActivity() {
    lateinit var login:Button
    lateinit var signup:TextView
    lateinit var forgotpass:TextView
    lateinit var dialog: Dialog
    lateinit var cardView: CardView

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
            var intent1= Intent(this@AuthentificationActivity, CreateAccountActivity::class.java)
            startActivity(intent1)
        }
        dialog= Dialog(this)
        forgotpass=findViewById<TextView>(R.id.forgot)
         forgotpass.setOnClickListener {
             var intent1= Intent(this@AuthentificationActivity,ForgotPasswordActivity::class.java)
             startActivity(intent1)
         }
       /* forgotpass.setOnClickListener(object: View.OnClickListener{
            override fun onClick(view: View) {
                openDialogPassword()
            }
        })*/
    }

    private fun openDialogPassword() {
        dialog.setContentView(R.layout.dialog_pass_fragment)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(TRANSPARENT))
        cardView=dialog.findViewById(R.id.card)
        dialog.show()
    }
}