package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView

class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_preview)
        val webView = findViewById<WebView>(R.id.webview)
        webView.webChromeClient = WebChromeClient()
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        val data = "<html>\n" +
                "<body>\n" +
                "<script>\n" +
                "function displayContent()\n" +
                "{\n" +
                "var a=document.getElementById(\"name\");\n" +
                "document.write(a.value);\n" +
                "\n" +
                "}\n" +
                "</script>\n" +
                "Name: <input type=\"text\" id=\"name\"/>\n" +
                "<br/><br/><input type=\"button\" value=\"Display\" onclick=\"displayContent()\" style=\"background-color:black;color: white; border: 2px solid #000000\"/>\n" +
                "</body>\n" +
                "\n" +
                "</html>"
                                                      
        webView.loadDataWithBaseURL(null, data, "text/html", "UTF-8", null)
    }
}
