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
    var emailView:EditText?=null
    var passwordView:EditText?=null
    var fullNameView:EditText?=null
    var dateOfBirthView:EditText?=null
    var emailInfo:String = ""
    var passwordInfo:String = ""
    var fullNameInfo:String = ""
    var dateOfBirthInfo: String =""
    var cityInfo:String=""
    var genderInfo:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        init()

        buttonSignUp?.setOnClickListener {
            emailInfo = emailView?.text.toString()
            passwordInfo = passwordView?.text.toString()
            fullNameInfo = fullNameView?.text.toString()
            dateOfBirthInfo = dateOfBirthView?.text.toString()
            cityInfo = spinnerCity?.selectedItem.toString()
            genderInfo = spinnerGender?.selectedItem.toString()


            val intent = Intent(this, LogInActivity::class.java)
            intent.putExtra("emailSignUp", emailInfo)
            intent.putExtra("passwordSignUp", passwordInfo)
            intent.putExtra("fullNameSignUp", fullNameInfo)
            intent.putExtra("dateOfBirthSignUp", dateOfBirthInfo)
            intent.putExtra("citySignUp", cityInfo)
            intent.putExtra("genderSignUp", genderInfo)
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
    fun init(){
        spinnerCity = findViewById(R.id.spinnerSignUpCity)
        spinnerGender = findViewById(R.id.spinnerSignUpGender)
        buttonSignUp = findViewById(R.id.button2SignIn)
        emailView = findViewById(R.id.editTextLogInEmail) as EditText
        passwordView = findViewById(R.id.editTextLogInPassword) as EditText
        fullNameView = findViewById(R.id.editTextSignUpFullName) as EditText
        dateOfBirthView = findViewById(R.id.editTextSignUpDateOfBirth) as EditText
    }
}

