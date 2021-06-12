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

        init()

        imageAppointments?.setOnClickListener{

            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)

        }

        imageProfile?.setOnClickListener{

            val intent = Intent(this, ProfileActivity::class.java)
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