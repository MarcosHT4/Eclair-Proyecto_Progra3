package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.*
import android.widget.Spinner

class LogInActivity : AppCompatActivity() {

    var buttonLogIn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        buttonLogIn = findViewById(R.id.button2LogIn)

        buttonLogIn?.setOnClickListener {

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)

        }



    }
}