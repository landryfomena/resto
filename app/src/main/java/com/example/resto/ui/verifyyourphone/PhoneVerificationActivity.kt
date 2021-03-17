package com.example.resto.ui.verifyyourphone

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import com.example.resto.R

class PhoneVerificationActivity : AppCompatActivity() {
    lateinit var dialog: Dialog
    lateinit var cardView: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_verification)
        dialog= Dialog(this)
        openDialogPassword()
    }
    private fun openDialogPassword() {
        dialog.setContentView(R.layout.dialog_pass_fragment)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(UCharacter.JoiningType.TRANSPARENT))
        cardView=dialog.findViewById(R.id.card)
        dialog.show()
    }
}