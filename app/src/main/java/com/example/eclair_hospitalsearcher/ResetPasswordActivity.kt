package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ResetPasswordActivity : AppCompatActivity() {

    var buttonSaveNewPassword: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        buttonSaveNewPassword = findViewById(R.id.buttonConfirmNewPassword)
        buttonSaveNewPassword?.setOnClickListener {

            val intent = Intent(this, MenuActivity::class.java )
            startActivity(intent)

        }

    }
}