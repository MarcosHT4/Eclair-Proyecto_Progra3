package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.*

class SignUpActivity : AppCompatActivity() {
    var spinnerCity: Spinner? = null
    var spinnerGender: Spinner? = null
    var buttonSignUp: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        spinnerCity = findViewById(R.id.spinner_city)
        spinnerGender = findViewById(R.id.spinnerGender)
        buttonSignUp = findViewById(R.id.button2SignIn)

        buttonSignUp?.setOnClickListener {

            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

        }

        ArrayAdapter.createFromResource(
            this,
            R.array.city,
            android.R.layout.simple_spinner_item

        ).also { adapter->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCity?.adapter = adapter

        }

        ArrayAdapter.createFromResource(
            this,
            R.array.gender,
            android.R.layout.simple_spinner_item

        ).also { adapter->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerGender?.adapter = adapter

        }
    }
}

