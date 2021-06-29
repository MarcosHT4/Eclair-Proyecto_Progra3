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
    val reqCode = 666
    var fullNameMenu:String = ""
    var databaseController = DatabaseController(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        fullNameMenu = intent.getStringExtra("fullNameMenu").toString()

        init()

        var toast = Toast.makeText(applicationContext, "${resources.getString(R.string.main_menu_toast_welcome)} $fullNameMenu!", Toast.LENGTH_LONG)
        toast.show()

        imageAppointments?.setOnClickListener{

            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)

        }

        imageProfile?.setOnClickListener{

            val intent = Intent(this, ProfileActivity::class.java)

            startActivityForResult(intent, reqCode)

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==reqCode) {


        }

    }
}