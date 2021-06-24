package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MenuActivity : AppCompatActivity() {

    var imageAppointments: ImageView? = null
    var imageProfile: ImageView? = null
    var imageHospitalSearch: ImageView? = null
    var imageEmergency: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        var emailMenu = intent.getStringArrayExtra("emailLogIn")
        var passwordMenu = intent.getStringArrayExtra("passwordLogIn")
        var dateOfBirthMenu = intent.getStringArrayExtra("dateOfBirthLogIn")
        var cityMenu = intent.getStringArrayExtra("cityLogIn")
        var genderMenu = intent.getStringArrayExtra("genderLogIn")
        var fullNameMenu = intent.getStringExtra("fullNameLogIn")
        init()
        var toast = Toast.makeText(applicationContext,"Bienvenido $fullNameMenu",Toast.LENGTH_LONG)
        toast.show()
        imageAppointments?.setOnClickListener{

            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)

        }

        imageProfile?.setOnClickListener{

            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("emailMenu", emailMenu)
            intent.putExtra("passwordMenu", passwordMenu)
            intent.putExtra("fullNameMenu", fullNameMenu)
            intent.putExtra("dateOfBirthMenu", dateOfBirthMenu)
            intent.putExtra("cityMenu", cityMenu)
            intent.putExtra("genderMenu", genderMenu)
            startActivity(intent)

        }

        imageHospitalSearch?.setOnClickListener {

            val intent = Intent(this, HospitalSearchMenuActivity::class.java)
            startActivity(intent)

        }

        imageEmergency?.setOnClickListener {

            val intent = Intent(this, EmergencyActivity::class.java)
            startActivity(intent)

        }
    }

    fun init() {

        imageAppointments = findViewById(R.id.imageViewAppointmentsMenu)
        imageProfile = findViewById(R.id.imageViewProfileMenu)
        imageHospitalSearch = findViewById(R.id.imageViewHospitalSearchMenu)
        imageEmergency = findViewById(R.id.imageViewEmergencyMenu)



    }
}