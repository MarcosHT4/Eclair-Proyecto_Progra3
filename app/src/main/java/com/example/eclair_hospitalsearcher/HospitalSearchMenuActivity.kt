package com.example.eclair_hospitalsearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HospitalSearchMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_search_menu)
        var details = "Tap to see details"
        var vaccineAvailable = "Vaccine Available"
        var vaccineUnavailable = "Vaccine Unavailable"

        val recyclerView:RecyclerView = findViewById(R.id.recyclerViewHospital)

        val hospitalOptionsList = listOf(

            HospitalOption("Hospital ArcoIris", details,vaccineAvailable,R.drawable.icon_vaccine_available),
            HospitalOption("Hospital Metodista", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable),
            HospitalOption("Clinica Los Angeles", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable),
            HospitalOption("Clinica Los Olivos", details, vaccineAvailable, R.drawable.icon_vaccine_available),
            HospitalOption("Hospital Universitario Japonés", details, vaccineAvailable, R.drawable.icon_vaccine_available),
            HospitalOption("Clinica Foianini", details, vaccineAvailable, R.drawable.icon_vaccine_available),
            HospitalOption("Hospital Oruro-Corea", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable),
            HospitalOption("Hospital Obrero", details,vaccineAvailable,R.drawable.icon_vaccine_available),
            HospitalOption("Hospital Daniel Bracamonte", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable),
            HospitalOption("Hospital San Roque", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable),
            HospitalOption("Hospital Monseñor Jesús Perez", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable),
            HospitalOption("Hospital Santa Barbara", details,vaccineAvailable,R.drawable.icon_vaccine_available),
            HospitalOption("Hospital del Gran Chaco", details,vaccineAvailable,R.drawable.icon_vaccine_available),
            HospitalOption("Hospital San Juan de Dios Entre Ríos", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable),
            HospitalOption("Hospital General Riberalta", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable),
            HospitalOption("Hospital General Jacobo Abularach", details,vaccineAvailable,R.drawable.icon_vaccine_available),
            HospitalOption("Hospital Roberto Galindo Terán", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable),
            HospitalOption("Cinica Intramedica", details,vaccineAvailable,R.drawable.icon_vaccine_available)
        )

        val adapter = OptionsRecyclerViewAdapter(this, hospitalOptionsList)
        val layoutManager =  LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

    }
}