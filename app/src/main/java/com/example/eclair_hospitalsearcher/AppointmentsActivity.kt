package com.example.eclair_hospitalsearcher

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ExpandableListView
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout


class AppointmentsActivity : AppCompatActivity() {

    var expandablelist:ExpandableListView? = null

    var groups:MutableList<String> = ArrayList()
    var items:HashMap<String, MutableList<String>> = HashMap<String, MutableList<String>>()
    var adapter:ExpandableList? = null
    var tabLayoutAppointments: TabLayout? = null
    var contadorGrupos:Int = 1
    var cancelImage:ImageView? = null
    val databaseController = DatabaseController(this)
    var listAppointments = mutableListOf<Appointment>()
    var listOfDeletedAppointments = mutableListOf<Appointment>()





    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        expandablelist = findViewById(R.id.appointmentsViewExpandable)
        listAppointments = databaseController.getAppointments()

        adapter = ExpandableList(this, listAppointments,  this)

        expandablelist?.setAdapter(adapter)
        init()







        adapter?.setOnGroupClickListener {



            if(tabLayoutAppointments!!.getTabAt(1)!!.isSelected) {


                listAppointments.remove(it)
                adapter?.notifyDataSetChanged()
                contadorGrupos--
                listOfDeletedAppointments.add(it)


            } else {

                adapter?.notifyDataSetChanged()


            }
        }





    }

    override fun onStop() {
        super.onStop()

        listOfDeletedAppointments.forEach {

            databaseController.deleteAppointment(it)
            updateAppointments()

        }

    }

    fun updateAppointments() {

        listAppointments = databaseController.getAppointments()
        adapter?.notifyDataSetChanged()

    }



    fun init() {


        tabLayoutAppointments = findViewById(R.id.tabLayoutAppointments)
        cancelImage = findViewById(R.id.imageViewCancel)

    }
}