package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.signInAction)

        loginButton.setOnClickListener {
            Toast.makeText(applicationContext, "Please wait while verifying your credentials", Toast.LENGTH_LONG).show()
        }
    }
}
