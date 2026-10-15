package com.example.mobileapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AccountHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_home)
        val downloadInvoice = findViewById<Button>(R.id.downLoad)
        downloadInvoice.setOnClickListener {
            val serviceIntent = Intent(this, DownloadInvoiceService::class.java)
            startService(serviceIntent)
        }
    }
}
