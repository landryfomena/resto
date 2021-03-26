package com.example.resto.ui.authentification

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.icu.lang.UCharacter.JoiningType.TRANSPARENT
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.resto.MainActivity
import com.example.resto.R
import com.example.resto.ui.createaccount.CreateAccountActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.safetynet.SafetyNet
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_authentification.*


class AuthentificationActivity : AppCompatActivity() {
    lateinit var login: Button
    lateinit var signup: TextView
    lateinit var forgotpass: TextView
    lateinit var dialog: Dialog
    lateinit var cardView: CardView
    lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    var TAG = "AuthentificationActivity"


    @Synchronized
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentification)
// ...
// Initialize Firebase Auth
        auth = Firebase.auth
        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)


        login = findViewById<Button>(R.id.login_btn)
        login.setOnClickListener {

            val providers = arrayListOf(
                AuthUI.IdpConfig.EmailBuilder().build())
// Create and launch sign-in intent
            startActivityForResult(
                AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),
                RC_SIGN_IN)
        }
        signup = findViewById<TextView>(R.id.sign_up)
        signup.setOnClickListener {

        }
        dialog = Dialog(this)
        forgotpass = findViewById<TextView>(R.id.forgot)
        forgotpass.setOnClickListener {
            var intent1 = Intent(this@AuthentificationActivity, ForgotPasswordActivity::class.java)
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
        cardView = dialog.findViewById(R.id.card)
        dialog.show()
    }

    var RC_SIGN_IN = 100

    fun signin() {
        // Choose authentication providers
        val providers = arrayListOf(
            AuthUI.IdpConfig.PhoneBuilder().build(),
        )

// Create and launch sign-in intent
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
            RC_SIGN_IN)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
                // Successfully signed in
                val user = FirebaseAuth.getInstance().currentUser
                // ...
                var intent = Intent(this@AuthentificationActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }


    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Authentication Activity", "signInWithCredential:failure", task.exception)
                    updateUI(null)
                }
            }
    }

    fun updateUI(user: FirebaseUser?) {


    }

}