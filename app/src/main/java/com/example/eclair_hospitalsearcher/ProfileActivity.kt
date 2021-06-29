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
    var editTextDateBirth:EditText? = null
    var emailTextProfile:EditText? = null
    var fullNameTextView:TextView? = null
    var editTextPhone:EditText? = null
    var reqCode = 555
    var password:String = ""
    val databaseController = DatabaseController(this)




    @TargetApi(Build.VERSION_CODES.N)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()





        var fullNameProfile = intent.getStringExtra("fullNameMenu")
        val currentUser = databaseController.getCurrentUser(fullNameProfile!!)
        var emailProfile = currentUser.email
        var password = currentUser.password


        var dateOfBirthProfile = currentUser.dateOfBirth

        var phone = currentUser.phone
        var bloodType = currentUser.bloodType

        fullNameTextView?.setText(fullNameProfile)
        editTextDateBirth?.setText(dateOfBirthProfile)
        emailTextProfile?.setText(emailProfile)
        spinnerBloodType?.setSelection(bloodType)
        editTextPhone?.setText(phone)




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
            spinnerBloodType?.setSelection(bloodType)

        }

        buttonSaveChanges?.setOnClickListener {

            val intent = Intent()

            var newUser = databaseController.getCurrentUser(fullNameProfile)
            var newDateOfBirth = editTextDateBirth?.text.toString()
            var newEmail = emailTextProfile?.text.toString()
            var newPhone = editTextPhone?.text.toString()
            var newBloodType = spinnerBloodType?.selectedItemPosition
            var newPassword = password

            if (newBloodType != null) {
                databaseController.updateUser(fullNameProfile, newEmail, newUser.password, newBloodType, newDateOfBirth, newUser.city, newUser.gender,newPhone)
            }




            setResult(RESULT_OK, intent)
            finish()

        }

        buttonChangePassword?.setOnClickListener {

            val intent = Intent(this, ResetPasswordActivity::class.java)
            intent.putExtra("fullNameProfile", fullNameProfile)
            startActivityForResult(intent, reqCode)



        }


    }

    fun showCalendar() {

        val datePicker = DatePickerFragment({day, month, year -> onDateSelected(day, month, year)})
        datePicker.show(supportFragmentManager, "datePicker")

    }

    fun onDateSelected(day:Int, month:Int, year:Int) {

        editTextProfile?.setText("$day / ${month+1} / $year")

    }

    fun init() {

        editTextProfile = findViewById(R.id.editTextDateProfile)
        spinnerBloodType = findViewById(R.id.spinnerBloodType)
        buttonChangePassword = findViewById(R.id.buttonResetPassword)
        buttonSaveChanges = findViewById(R.id.buttonSaveChanges)
        editTextDateBirth = findViewById(R.id.editTextDateProfile)
        emailTextProfile = findViewById(R.id.editTextEmailProfile)
        fullNameTextView = findViewById(R.id.textViewFullNameProfile)
        editTextPhone = findViewById(R.id.editTextPhone)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == reqCode) {

            password = data?.getStringExtra("newPassword").toString()

        }
    }




}