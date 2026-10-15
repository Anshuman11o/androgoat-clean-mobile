package com.example.mobileapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class DeviceInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_info)

        val deviceInfoAction = findViewById<Button>(R.id.deviceInfoAction)
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Device information")
        deviceInfoAction.setOnClickListener {
            if (matchesVirtualDeviceProfile()) {
                builder.setMessage("This device uses a virtual profile")
                Toast.makeText(applicationContext, "This device uses a virtual profile", Toast.LENGTH_LONG).show()
            } else {
                builder.setMessage("This device uses a physical profile")
                Toast.makeText(applicationContext, "This device uses a physical profile", Toast.LENGTH_LONG).show()
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }
    }

    private fun matchesVirtualDeviceProfile(): Boolean {
        val buildDetails = (Build.FINGERPRINT + Build.DEVICE + Build.MODEL + Build.BRAND + Build.PRODUCT + Build.MANUFACTURER + Build.HARDWARE).toLowerCase()
        return (buildDetails.contains("generic")
                || buildDetails.contains("unknown")
                || buildDetails.contains("emulator")
                || buildDetails.contains("sdk")
                || buildDetails.contains("vbox")
                || buildDetails.contains("genymotion")
                || buildDetails.contains("x86")
                || buildDetails.contains("goldfish")
                || buildDetails.contains("test-keys"))
    }
}
