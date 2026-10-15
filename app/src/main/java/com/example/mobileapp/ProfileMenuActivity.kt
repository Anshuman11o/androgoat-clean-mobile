package com.example.mobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ProfileMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_menu)
        val spButton = findViewById<Button>(R.id.SPButton)
        spButton.setOnClickListener{
            startActivity(Intent (this, ProfileActivity::class.java))
        }

        val profileAction = findViewById<Button>(R.id.profileAction)
        profileAction.setOnClickListener{
            startActivity(Intent (this, ScoreActivity::class.java))
        }

        val directoryAction = findViewById<Button>(R.id.directoryAction)
        directoryAction.setOnClickListener{
            startActivity(Intent (this, DirectoryEditorActivity::class.java))
        }

        val tempButton = findViewById<Button>(R.id.tempButton)
        tempButton.setOnClickListener{
            startActivity(Intent (this, ProfileDraftActivity::class.java))
        }

        val sDcardButton = findViewById<Button>(R.id.SDcardButton)
        sDcardButton.setOnClickListener {
            startActivity(Intent(this, ProfileExportActivity::class.java))
        }
    }
}
