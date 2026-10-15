package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val deviceStatusMenu = findViewById<Button>(R.id.deviceStatusMenu)
        deviceStatusMenu.setOnClickListener {
            startActivity(Intent(this, DeviceStatusActivity::class.java))
        }

        val deviceInfoMenu = findViewById<Button>(R.id.deviceInfoMenu)
        deviceInfoMenu.setOnClickListener {
            startActivity(Intent(this, DeviceInfoActivity::class.java))
        }

        val profileMenu = findViewById<Button>(R.id.ProfileMenu)
        profileMenu.setOnClickListener {
            startActivity(Intent(this, ProfileMenuActivity::class.java))
        }

        val toolsMenu = findViewById<Button>(R.id.ToolsMenu)
        toolsMenu.setOnClickListener {
            startActivity(Intent(this, ToolsActivity::class.java))
        }

        val utilitiesMenu = findViewById<Button>(R.id.UtilitiesMenu)
        utilitiesMenu.setOnClickListener {
            startActivity(Intent(this, UtilitiesActivity::class.java))
        }

        val accessControl1 = findViewById<Button>(R.id.AccountMenu)
        accessControl1.setOnClickListener {
            startActivity(Intent(this, AccountLoginActivity::class.java))
        }

        val checkout = findViewById<Button>(R.id.ServicesMenu)
        checkout.setOnClickListener {
            startActivity(Intent(this, ServicesActivity::class.java))
        }

        val traffic = findViewById<Button>(R.id.Traffic)
        traffic.setOnClickListener {
            startActivity(Intent(this, TrafficActivity::class.java))
        }

        val adminPanel = findViewById<Button>(R.id.AdminPanel)
        adminPanel.setOnClickListener {
            startActivity(Intent(this, AdminPanelActivity::class.java))
        }

        val biopath = findViewById<Button>(R.id.bioauth1)
        biopath.setOnClickListener {
            startActivity(Intent(this, BioMetricAuthActivity::class.java))
        }
    }
}
