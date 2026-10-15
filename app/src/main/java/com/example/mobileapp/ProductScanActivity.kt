package com.example.mobileapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback

class ProductScanActivity : AppCompatActivity() {

    private lateinit var codeScanner: CodeScanner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_scan)

                                      
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 101)
        }

        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)
        val webView = findViewById<WebView>(R.id.productPreview)

                                                          
        webView.settings.javaScriptEnabled = true
        webView.webChromeClient = WebChromeClient()                         

                                
        codeScanner = CodeScanner(this, scannerView)

                                  
        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                val scannedText = it.text

                                                                                        
                val htmlData = """
                    <html>
                    <body>
                        <h2>Scanned Product Details</h2>
                        <h3>Product Found!</h3>
                        <p>Product ID: <b>$scannedText</b></p>
                        <p>Status: Available</p>
                    </body>
                    </html>
                """.trimIndent()

                                         
                webView.loadData(htmlData, "text/html", "UTF-8")

                Toast.makeText(this, "Scan Complete", Toast.LENGTH_SHORT).show()
            }
        }

                                      
        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
    }

    override fun onResume() {
        super.onResume()
        if (::codeScanner.isInitialized) {
            codeScanner.startPreview()
        }
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }
}