package com.example.eclair_hospitalsearcher

import android.annotation.TargetApi
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.EditText
import android.widget.*
import androidx.annotation.RequiresApi
import java.util.*

class ProfileActivity : AppCompatActivity() {

    var editTextProfile:EditText? = null
    var spinnerBloodType: Spinner? = null
    var buttonSaveChanges:Button? = null
    var buttonChangePassword:Button? = null

    @TargetApi(Build.VERSION_CODES.N)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        var dateOfBirthProfile = intent.getStringExtra("dateOfBirthMenu")
        editTextProfile?.setOnClickListener {

            showCalendar()

        }

        ArrayAdapter.createFromResource(
            this,
            R.array.blood_types,
            android.R.layout.simple_spinner_item

        ).also { adapter->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerBloodType?.adapter = adapter

        }

        buttonSaveChanges?.setOnClickListener {

            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()

        }

        buttonChangePassword?.setOnClickListener {

            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)


        }


    }

    fun showCalendar() {

        val datePicker = DatePickerFragment({day, month, year -> onDateSelected(day, month, year)})
        datePicker.show(supportFragmentManager, "datePicker")

    }

    fun onDateSelected(day:Int, month:Int, year:Int) {

        editTextProfile?.setText("$day / $month / $year")

    }

    fun init() {

        editTextProfile = findViewById(R.id.editTextDateProfile)
        spinnerBloodType = findViewById(R.id.spinnerBloodType)
        buttonChangePassword = findViewById(R.id.buttonResetPassword)
        buttonSaveChanges = findViewById(R.id.buttonSaveChanges)

    }




}