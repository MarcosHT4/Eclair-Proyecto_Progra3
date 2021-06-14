package com.example.eclair_hospitalsearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class HospitalSearchMenuActivity : AppCompatActivity() {

    var hospitalListView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_search_menu)
        hospitalListView = findViewById(R.id.listViewHospitals)
        val hospitals = arrayListOf("Hospital 1 ", "Hospital 2", "Hospital 3", "Hospital 4", "Hospital 5", "Hospital 6")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, hospitals)
        hospitalListView?.adapter = adapter
        hospitalListView?.setOnItemClickListener { adapterView, view, i, l ->


        }


    }
}