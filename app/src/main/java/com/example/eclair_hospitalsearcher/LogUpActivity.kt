package com.example.eclair_hospitalsearcher

import android.content.Intent
import android.graphics.Color.red

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LogUpActivity : AppCompatActivity() {

    var buttonLogin:Button? = null
    var buttonSignUp: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_up)
        buttonLogin = findViewById(R.id.buttonLogIn)
        buttonSignUp = findViewById(R.id.buttonSignUp)



        buttonLogin!!.setOnClickListener {

            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

        }

        buttonSignUp!!.setOnClickListener {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }


    }
}