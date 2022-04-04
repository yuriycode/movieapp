package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.FirebaseAuthUIActivityResultContract
import com.firebase.ui.auth.data.model.FirebaseAuthUIAuthenticationResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.auth.User


class MainActivity : AppCompatActivity() {


    private fun onSignInResult(res: FirebaseAuthUIAuthenticationResult?) {
        TODO("Not yet implemented")
    }
    private val signInLauncher = registerForActivityResult(
        FirebaseAuthUIActivityResultContract()
    ) { res ->
        this.onSignInResult(res)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("testlogs", "in onCreate")
        setContentView(R.layout.activity_main)

        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build()
        )

        val registerbutton = findViewById<Button>(R.id.main_activity_button_input)
        registerbutton.setOnClickListener {
            Log.d("testlogs", "ClickRegister")
            Toast.makeText(this@MainActivity, "Registration complete.", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)

            val loginbutton = findViewById<TextView>(R.id.simpleTextView)
            loginbutton.setOnClickListener {
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)

                val signInIntent = AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build()
                signInLauncher.launch(signInIntent)
            }

            fun onSignInResult(result: FirebaseAuthUIAuthenticationResult) {
                val response = result.idpResponse // результат с экрана Firebase Auth
                if (result.resultCode == RESULT_OK) { // если результат не ОК
                    // Успешно вошли
                    val authUser = FirebaseAuth.getInstance().currentUser // создаем обьект текущего пользователя Firebase Auth
                    val user = authUser?.let { it1 ->
                    getDatabasePath("users")
                        onBackPressed() // для переброса на главный экран после регистрации
                    }
                }
                else   { // должны обработать ошибку

                }
            }
        }

    }

}



