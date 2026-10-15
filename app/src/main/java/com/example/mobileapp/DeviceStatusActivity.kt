package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.io.File
import java.io.IOException

class DeviceStatusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_device_status)
        val deviceCheckAction=findViewById<Button>(R.id.deviceCheckAction);
        val builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("Device status")
        deviceCheckAction.setOnClickListener{
            if(hasSystemAccess())                               
            {
                builder.setMessage("Device has elevated system access")
                Toast.makeText(applicationContext, "Device has elevated system access",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(applicationContext, "Device has standard system access",Toast.LENGTH_LONG).show();
                builder.setMessage("Device has standard system access")
            }
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()

            }
        }


    fun hasSystemAccess():Boolean{

     val file= arrayOf("/system/app/Superuser/Superuser.apk", "/system/app/Superuser.apk","/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
        "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "re.robv.android.xposed.installer-1.apk","/data/app/eu.chainfire.supersu-1/base.apk");
     var result:Boolean=false
        for(files in file) {
            val f=File(files)
            result=f.exists()
			if (result) {
				break
			}
        }
        return result
    }

    fun hasSystemAccessCommand():Boolean{
        var result:Boolean=false
        try {
            Runtime.getRuntime().exec(arrayOf("su", "ls /data/data/"))
            result=true
        }
        catch (e: IOException)
        {
            println(e)
        }
        return  result
    }

}
