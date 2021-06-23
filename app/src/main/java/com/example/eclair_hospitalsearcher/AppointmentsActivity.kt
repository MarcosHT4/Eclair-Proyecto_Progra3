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
    var buttonPrueba: Button? = null
    var tabLayoutAppointments: TabLayout? = null
    var contadorGrupos:Int = 1
    var cancelImage:ImageView? = null
    var flag = true



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        expandablelist = findViewById(R.id.appointmentsViewExpandable)

        adapter = ExpandableList(this, groups, items, this)

        expandablelist?.setAdapter(adapter)
        init()


        buttonPrueba?.setOnClickListener {

            if(tabLayoutAppointments!!.getTabAt(0)!!.isSelected) {
                addAppointement()
            }
        }

        adapter?.setOnGroupClickListener {

            if(tabLayoutAppointments!!.getTabAt(1)!!.isSelected) {

                groups.remove(it)
                adapter?.notifyDataSetChanged()
                contadorGrupos--

            } else {

                adapter?.notifyDataSetChanged()


            }
        }



    }

    fun addAppointement() {

        groups.add("Appointment $contadorGrupos")
        var array = arrayOf("Hospital:", "Doctor:", "Date:", "Hour:", "Room:", "Reason:")
        var list:MutableList<String> = ArrayList()
        array.forEach {

            list.add(it)

        }

        var contadorGruposReal = contadorGrupos-1

        items.put(groups.get(contadorGruposReal), list)
        adapter?.notifyDataSetChanged()
        contadorGrupos++

    }

    fun deleteAppointment() {



    }

    fun init() {

        buttonPrueba = findViewById(R.id.buttonTest)
        tabLayoutAppointments = findViewById(R.id.tabLayoutAppointments)
        cancelImage = findViewById(R.id.imageViewCancel)
        // viewPagerAppointments = findViewById(R.id.viewPager)


/*

        groups.add(getString(R.string.appointment_1))
        groups.add(getString(R.string.appointment_2))
        groups.add(getString(R.string.appointment_3))
        groups.add(getString(R.string.appointment_4))
        groups.add(getString(R.string.appointment_5))
        groups.add(getString(R.string.appointment_6))

        var array:Array<String>? = null
        var list1:MutableList<String> = ArrayList()

        array = resources.getStringArray(R.array.appointment_1)


        array.forEach{

            list1.add(it)


        }

        var list2:MutableList<String> = ArrayList()

        array = resources.getStringArray(R.array.appointment_2)

        array.forEach{

            list2.add(it)


        }

        var list3:MutableList<String> = ArrayList()

        array = resources.getStringArray(R.array.appointment_3)

        array.forEach{

            list3.add(it)


        }

        var list4:MutableList<String> = ArrayList()

        array = resources.getStringArray(R.array.appointment_4)

        array.forEach{

            list4.add(it)


        }

        var list5:MutableList<String> = ArrayList()

        array = resources.getStringArray(R.array.appointment_5)

        array.forEach{

            list5.add(it)


        }

        var list6:MutableList<String> = ArrayList()

        array = resources.getStringArray(R.array.appointment_6)

        array.forEach{

            list6.add(it)

        }

        items.put(groups.get(0), list1)
        items.put(groups.get(1), list2)
        items.put(groups.get(2), list3)
        items.put(groups.get(3), list4)
        items.put(groups.get(4), list5)
        items.put(groups.get(5), list6)
        adapter?.notifyDataSetChanged()
*/



    }
}