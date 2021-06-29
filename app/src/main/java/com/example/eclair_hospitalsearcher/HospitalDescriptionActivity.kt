package com.example.eclair_hospitalsearcher

import android.content.Intent
import android.net.Uri
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
    var imageViewMapHospital:ImageView?=null
    val listDoctors: List<String> = listOf("James Cameron", "Dallas Azahar", "Dr. House", "Dr. Vic", "Carolina Wieser", "Erick Saucedo", "Aaron Barrera", "William Osler", "Sigmud Freud", "Derek Styles", "Alexander Fleming")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_description)

        init()
        hospitalName = intent.getStringExtra("nameHospital")


        var phoneData = intent.getIntExtra("phoneHospital", 0)
        var locationData = intent.getStringExtra("locationHospital")
        var imageHospitalData = intent.getIntExtra("photoHospital", 0)
        var ratingHospitalData = intent.getIntExtra("ratingHospital", 0)
        var hospitalMapCoordenates=intent.getStringExtra("coordenatesMapHospital").toString()

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

        imageViewMapHospital?.setOnClickListener{
            var hospitalTrueCoordenates= Uri.parse(hospitalMapCoordenates)
            val intent=Intent(Intent.ACTION_VIEW,hospitalTrueCoordenates)
            startActivity(intent)

        }



    }
    fun init(){
        imageHospital = findViewById(R.id.imageViewHeaderHospital)
        imageRating = findViewById(R.id.imageViewRating)
        phone = findViewById(R.id.textViewPhoneNumber)
        location = findViewById(R.id.textViewLocationAddress)
        imageViewMapHospital=findViewById(R.id.imageViewMapHospital)
        appointmentsButton = findViewById(R.id.floatingButtonAppointment)


    }
}