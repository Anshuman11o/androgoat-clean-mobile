package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class UtilitiesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_utilities)
        val logging = findViewById<Button>(R.id.signInMenu)
        logging.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
        val codeTransfer = findViewById<Button>(R.id.paymentCodeAction)
        codeTransfer.setOnClickListener{
            startActivity(Intent(this, PaymentCodeActivity::class.java))
        }
        val dict = findViewById<Button>(R.id.Dict)
        dict.setOnClickListener{
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}
