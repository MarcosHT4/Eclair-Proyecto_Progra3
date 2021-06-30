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
        val details = resources.getString(R.string.details_hospitalSearchMenu)
        val vaccineAvailable = resources.getString(R.string.vaccine_available_hospitalSearchMenu)
        val vaccineUnavailable = resources.getString(R.string.vaccine_unavailable_hospitalSearchMenu)


        val recyclerView:RecyclerView = findViewById(R.id.recyclerViewHospital)

        val hospitalOptionsList = listOf(

            HospitalOption("Hospital ArcoIris", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_arcoiris, R.drawable.icon_three_stars, 74901912, " Villa Fátima Av. 15 de Abril #40", "geo:-16.48405326836312, -68.12037713500769"),
            HospitalOption("Hospital Metodista", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_metodista, R.drawable.icon_four_stars, 2783372, "Av. 14 de septiembre & calle 12 de obrajes 15000", "geo:-16.526213338330287, -68.10466107671338"),
            HospitalOption("Clinica Los Angeles", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_clinica_los_angeles, R.drawable.icon_three_stars, 44012370, "Av. Juan de la Rosa esq. Julio Mendez, Barrio Cala Cala", "geo:-17.378439599448264, -66.16478158247216"),
            HospitalOption("Clinica Los Olivos", details, vaccineAvailable, R.drawable.icon_vaccine_available, R.drawable.image_clinica_los_olivos, R.drawable.icon_four_stars, 4408801, "Av Melchor Pérez de Olguín", "geo:-17.38838477835983, -66.17857429887393"),
            HospitalOption("Hospital Universitario Japonés", details, vaccineAvailable, R.drawable.icon_vaccine_available, R.drawable.image_hospital_universitario_japones, R.drawable.icon_three_stars, 33462031, "Av. Japón 3er Anillo Interno", "geo:-17.772103693638197, -63.15506778875874"),
            HospitalOption("Clinica Foianini", details, vaccineAvailable, R.drawable.icon_vaccine_available, R.drawable.image_foianini, R.drawable.icon_five_stars, 33362211, "Calle Chuquisaca 737", "geo:-17.791172828122615, -63.17991142479561"),
            HospitalOption("Hospital Oruro-Corea", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_orurocorea, R.drawable.icon_four_stars, 25275405, "San Felipe Y 6 De Octubre ", "geo:-17.97611832659192, -67.10010875767132"),
            HospitalOption("Hospital Obrero", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_obrero, R.drawable.icon_two_stars, 25235367, "Av. La paz Entre Sargento Flores y Av. Lira", "geo:-17.95646188984058, -67.1125517"),
            HospitalOption("Hospital Daniel Bracamonte", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_daniel_bracamonte, R.drawable.icon_three_stars, 26244960,"Chaca s/n Potosí, Bolivia", "geo:-19.582661700456754, -65.76573195175662"),
            HospitalOption("Hospital San Roque", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_san_roque, R.drawable.icon_four_stars, 25972555, "Avenida Tumusla", "geo:-19.578099621371134, -65.75007085175665"),
            HospitalOption("Hospital Monseñor Jesús Perez", details, vaccineUnavailable, R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_monsenor_jesus_perez, R.drawable.icon_five_stars, 46422524, "Calvo # 381 entre Padilla y Potosi ", "geo:-19.05007778385617, -65.25544403068535"),
            HospitalOption("Hospital Santa Barbara", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_santa_barbara, R.drawable.icon_four_stars, 46435240, "Plazuela Libertad Nº1 ", "geo:-19.04464882966231, -65.26295341841815"),
            HospitalOption("Hospital del Gran Chaco", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_del_gran_chaco, R.drawable.icon_four_stars, 46116444, "Yacuiba Aeropuerto, Yacuíba", "geo:-21.947095768758526, -63.6131198184264"),
            HospitalOption("Hospital San Juan de Dios Entre Ríos", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_san_juan_de_dios_entre_rios, R.drawable.icon_one_star, 46645555, "Barrio Manuel Marzana, Calle Benemeritos", "geo:-21.529488912460955, -64.7260419865467"),
            HospitalOption("Hospital General Riberalta", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_general_riberalta, R.drawable.icon_three_stars, 43191911, "Riberalta S/N", "geo:-11.000037387203356, -66.05948240093034"),
            HospitalOption("Hospital General Jacobo Abularach", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_hospital_general_jacobo_abularach, R.drawable.icon_five_stars, 34842118, "Alejandro Rodriguez, Santa Ana del Yacuma", "geo:-13.745358754976802, -65.43001273948119"),
            HospitalOption("Hospital Roberto Galindo Terán", details,vaccineUnavailable,R.drawable.icon_vaccine_unavailable, R.drawable.image_hospital_roberto_galindo_teran, R.drawable.icon_three_stars, 38423894, "Barrio 11 de Octubre Km. 2", "geo:-11.032822598155075, -68.76725689397672"),
            HospitalOption("Clinica Integramedica", details,vaccineAvailable,R.drawable.icon_vaccine_available, R.drawable.image_clinica_intramedica, R.drawable.icon_four_stars, 72927024, "Barrio 11 de octubre Km 2 AV. 9 de Febrero#071", "geo:-11.034599006938933, -68.76817298956972")
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
            intent.putExtra("coordenatesMapHospital", hospitalOption.coordenates)
            startActivity(intent)


        }

    }
}