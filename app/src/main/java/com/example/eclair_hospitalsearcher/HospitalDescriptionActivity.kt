package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HospitalDescriptionActivity : AppCompatActivity() {

    var imageHospital: ImageView? = null
    var imageRating:ImageView? = null
    var phone:TextView? = null
    var location:TextView? = null
    var hospitalName:String? = null
    var appointmentsButton:FloatingActionButton? = null
    val defaultName = "James Cameron"
    val listDoctors: List<String> = listOf("James Cameron", "Dallas Azahar", "Dr. House", "Dr. Vic", "Carolina Wieser", "Erick Saucedo", "Aaron Barrera", "William Osler", "Sigmud Freud", "Derek Styles", "Alexander Fleming")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_description)

        imageHospital = findViewById(R.id.imageViewHeaderHospital)
        imageRating = findViewById(R.id.imageViewRating)
        phone = findViewById(R.id.textViewPhoneNumber)
        location = findViewById(R.id.textViewLocationAddress)
        appointmentsButton = findViewById(R.id.floatingButtonAppointment)
        hospitalName = intent.getStringExtra("nameHospital")


        var phoneData = intent.getIntExtra("phoneHospital", 0)
        var locationData = intent.getStringExtra("locationHospital")
        var imageHospitalData = intent.getIntExtra("photoHospital", 0)
        var ratingHospitalData = intent.getIntExtra("ratingHospital", 0)

        phone?.setText(phoneData.toString())
        location?.setText(locationData)
        imageHospital?.setImageResource(imageHospitalData)
        imageRating?.setImageResource(ratingHospitalData)

        appointmentsButton?.setOnClickListener{

            val intent = Intent(this, AppointmentCreationActivity::class.java)
            intent.putExtra("nameHospital", hospitalName)

            val nameDoctor = listDoctors.get((0..10).random())

            intent.putExtra("nameDoctor", nameDoctor)

            val rnd = "${(0..20).random()}${('A'..'Z').random()}"
            intent.putExtra("roomAppointment", rnd)
            startActivity(intent)

        }






    }
}