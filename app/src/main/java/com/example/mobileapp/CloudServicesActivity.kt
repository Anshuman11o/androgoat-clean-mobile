package com.example.mobileapp

import android.os.Bundle
import android.widget.Button
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CloudServicesActivity : AppCompatActivity() {
    private val aws_access_key_id = "svcb87e4b214e3c5c8d5b"
    private val aws_secret_access_key = "09aa94a2efa27f7efda0bc98fcb09d027654194c"
    val output = "json"
    val region = "ap-south-2"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cloud_services)
        val cloudServices = findViewById<Button>(R.id.viewCloudServices)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Login")
        cloudServices.setOnClickListener {
            builder.setMessage("Connected to AWS account using Access key " + aws_access_key_id + " and secret key " + aws_secret_access_key)
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
                                                                                                                                                                                         
            Log.d("[Info]", "Connected to AWS account using Access key " + aws_access_key_id + " and secret key " + aws_secret_access_key)
            setContentView(R.layout.activity_cloud_services_view)
        }
    }
}