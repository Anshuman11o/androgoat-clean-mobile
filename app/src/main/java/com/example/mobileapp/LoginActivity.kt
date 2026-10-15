package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val username = findViewById<EditText>(R.id.userName)
        val password = findViewById<EditText>(R.id.password)
        val signInAction = findViewById<Button>(R.id.signInAction)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Login")
        signInAction.setOnClickListener {
            val logMessage = "Username: ${username.text} and Password: ${password.text} are verified"
            Log.i("Info:", logMessage)
            System.out.println(logMessage)
            builder.setMessage("Username and Password are verified")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
            Toast.makeText(this, "Username and Password are verified", Toast.LENGTH_LONG).show()
        }
    }
}
