package com.example.mobileapp
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.StrictMode
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException
class TrafficActivity : AppCompatActivity() {
    var httpurl= "http://example.com"
    var httpsurl= "https://owasp.org"
    var httpsurl1= "https://cve.org"
    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic)

                                                                       
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)

        val HttpButton = findViewById<Button>(R.id.httpButton)
        val HttpsButton = findViewById<Button>(R.id.httpsButton)
        val connectionAction = findViewById<Button>(R.id.connectionAction)
        val alternateConnectionAction = findViewById<Button>(R.id.alternateConnectionAction)

                           
        HttpButton.setOnClickListener {
            run(httpurl)
        }

                            
        HttpsButton.setOnClickListener {
            run(httpsurl)
        }

                                

        connectionAction.setOnClickListener {
            checkServiceIdentity()
        }

                               
        alternateConnectionAction.setOnClickListener {
            run(httpsurl1)
        }

    }          


     fun run(url: String) {
         try {
             val request = Request.Builder()
                 .url(url)
                 .build()
             Toast.makeText(this, "Request sent to "+url+"", Toast.LENGTH_LONG).show()

             client.newCall(request).enqueue(object : Callback {
                 override fun onFailure(call: Call, e: IOException) {}
                 override fun onResponse(call: Call, response: Response) = println(response.body?.string())
             })
         }
         catch (e:Exception)
         {
             e.printStackTrace()
         }
     }     

    fun checkServiceIdentity()
    {
        CoroutineScope(Dispatchers.IO).launch {
            val url="owasp.org"
            try {
                val pinner1 = CertificatePinner.Builder()
                    .add(url, "sha256/5gsjyidrmWjcLRClfCk+Dd6O0nx1CyFrVUW5wVkwEx0=")
                    .add(url, "sha256/kIdp6NNEd8wsugYyyIYFsi1ylMCED3hZbSR8ZFsa/A4=")
                    .add(url, "sha256/mEflZT5enoR1FuXLgYYGqnVEoZvmf9c2bVBpiOjYQ0c=")
                    .build()
                val client = OkHttpClient.Builder().certificatePinner(pinner1).build()
                val request = Request.Builder()
                    .url("https://"+url)
                    .build()
                                                                                                                
                val response = client.newCall(request).execute()
                Log.v("Response", "${response.body?.string()}")
            } catch (e: Exception) {
                                                                                                               
                e.printStackTrace()
            }
        }

    }                        
}