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
    var emailMenu:String = ""
    var passwordMenu:String = ""
    var dateOfBirthMenu:String = ""
    var cityMenu:String = ""
    var genderMenu:String = ""
    var fullNameMenu:String = ""
    var bloodType:Int = 0
    var phone:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
         emailMenu = intent.getStringExtra("emailLogIn").toString()
         passwordMenu = intent.getStringExtra("passwordLogIn").toString()
         dateOfBirthMenu = intent.getStringExtra("dateOfBirthLogIn").toString()
         cityMenu = intent.getStringExtra("cityLogIn").toString()
         genderMenu = intent.getStringExtra("genderLogIn").toString()
         fullNameMenu = intent.getStringExtra("fullNameLogIn").toString()
        init()

        var toast = Toast.makeText(applicationContext, "Bienvenido $fullNameMenu!", Toast.LENGTH_LONG)
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
            intent.putExtra("bloodType", bloodType)
            intent.putExtra("phone", phone)
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

            emailMenu = data?.getStringExtra("newEmail").toString()
            dateOfBirthMenu = data?.getStringExtra("newDateOfBirth").toString()
            phone = data?.getStringExtra("newPhone").toString()
            bloodType = data!!.getIntExtra("newBloodType", 0)
            passwordMenu = data?.getStringExtra("newPassword").toString()


        }

    }
}