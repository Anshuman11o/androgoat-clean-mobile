package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ToolsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tools)

        val previewButton = findViewById<Button>(R.id.previewButton)
        previewButton.setOnClickListener {
            startActivity(Intent(this, PreviewActivity::class.java))
        }

        val directoryButton = findViewById<Button>(R.id.directoryButton)
        directoryButton.setOnClickListener {
            startActivity(Intent(this, DirectorySearchActivity::class.java))
        }

        val wbUrl = findViewById<Button>(R.id.wbUrl)
        wbUrl.setOnClickListener {
            startActivity(Intent(this, BrowserActivity::class.java))
        }

        val qrcode = findViewById<Button>(R.id.qrcode)
        qrcode.setOnClickListener {
            startActivity(Intent(this, ProductScanActivity::class.java))
        }
    }
}
