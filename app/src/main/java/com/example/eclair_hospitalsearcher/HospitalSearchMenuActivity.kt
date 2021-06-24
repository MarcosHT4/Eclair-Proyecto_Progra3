package com.example.eclair_hospitalsearcher

import android.content.Intent
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

            HospitalOption("Hospital ArcoIris", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_arcoiris, R.drawable.icon_three_stars, 74901912, " Villa Fátima Av. 15 de Abril #40"),
            HospitalOption("Hospital Metodista", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_metodista, R.drawable.icon_four_stars, 2783372, "Av. 14 de septiembre & calle 12 de obrajes 15000"),
            HospitalOption("Clinica Los Angeles", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_clinica_los_angeles, R.drawable.icon_three_stars, 44012370, "Av. Juan de la Rosa esq. Julio Mendez, Barrio Cala Cala"),
            HospitalOption("Clinica Los Olivos", details, vaccineAvailable, R.drawable.icon_vaccine_available, R.drawable.image_clinica_los_olivos, R.drawable.icon_four_stars, 4408801, "Av Melchor Pérez de Olguín"),
            HospitalOption("Hospital Universitario Japonés", details, vaccineAvailable, R.drawable.icon_vaccine_available, R.drawable.image_hospital_universitario_japones, R.drawable.icon_three_stars, 33462031, "Av. Japón 3er Anillo Interno"),
            HospitalOption("Clinica Foianini", details, vaccineAvailable, R.drawable.icon_vaccine_available, R.drawable.image_foianini, R.drawable.icon_five_stars, 33362211, "Calle Chuquisaca 737"),
            HospitalOption("Hospital Oruro-Corea", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_orurocorea, R.drawable.icon_four_stars, 25275405, "San Felipe Y 6 De Octubre "),
            HospitalOption("Hospital Obrero", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_obrero, R.drawable.icon_two_stars, 25235367, "Av. La paz Entre Sargento Flores y Av. Lira"),
            HospitalOption("Hospital Daniel Bracamonte", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_daniel_bracamonte, R.drawable.icon_three_stars, 26244960,"Chaca s/n Potosí, Bolivia"),
            HospitalOption("Hospital San Roque", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_san_roque, R.drawable.icon_four_stars, 25972555, "Avenida Tumusla"),
            HospitalOption("Hospital Monseñor Jesús Perez", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_monsenor_jesus_perez, R.drawable.icon_five_stars, 46422524, "Calvo # 381 entre Padilla y Potosi "),
            HospitalOption("Hospital Santa Barbara", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_santa_barbara, R.drawable.icon_four_stars, 46435240, "Plazuela Libertad Nº1 "),
            HospitalOption("Hospital del Gran Chaco", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_del_gran_chaco, R.drawable.icon_four_stars, 46116444, "Yacuiba Aeropuerto, Yacuíba"),
            HospitalOption("Hospital San Juan de Dios Entre Ríos", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_san_juan_de_dios_entre_rios, R.drawable.icon_one_star, 46645555, "Barrio Manuel Marzana, Calle Benemeritos" ),
            HospitalOption("Hospital General Riberalta", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_general_riberalta, R.drawable.icon_three_stars, 43191911, "Riberalta S/N"),
            HospitalOption("Hospital General Jacobo Abularach", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_general_jacobo_abularach, R.drawable.icon_five_stars, 34842118, "Alejandro Rodriguez, Santa Ana del Yacuma"),
            HospitalOption("Hospital Roberto Galindo Terán", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_roberto_galindo_teran, R.drawable.icon_three_stars, 38423894, "Barrio 11 de Octubre Km. 2"),
            HospitalOption("Clinica Integramedica", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_clinica_intramedica, R.drawable.icon_four_stars, 72927024, "Barrio 11 de octubre Km 2 AV. 9 de Febrero#071")
        )

        val adapter = OptionsRecyclerViewAdapter(this, hospitalOptionsList)
        val layoutManager =  LinearLayoutManager(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

        adapter.setOnMenuOptionClickListener { hospitalOption ->

            val intent = Intent(this, HospitalDescriptionActivity::class.java)
            intent.putExtra("nameHospital", hospitalOption.title)
            intent.putExtra("photoHospital", hospitalOption.imageHospital)
            intent.putExtra("ratingHospital", hospitalOption.rating)
            intent.putExtra("phoneHospital", hospitalOption.phone)
            intent.putExtra("locationHospital", hospitalOption.ubication)
            startActivity(intent)


        }

    }
}