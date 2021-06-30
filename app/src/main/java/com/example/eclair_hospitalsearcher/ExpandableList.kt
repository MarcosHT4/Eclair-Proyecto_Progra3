package com.example.eclair_hospitalsearcher

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.BaseExpandableListAdapter

class ExpandableList(var context: Context, var groups:MutableList<Appointment>, var appointmentsActivity: AppointmentsActivity): BaseExpandableListAdapter() {

    var groupClickListener: ((group: Appointment)-> Unit)? = null

    override fun getGroupCount(): Int {
        return groups.size
    }

    override fun getChildrenCount(p0: Int): Int {

        return 6


    }

    override fun getGroup(p0: Int): Appointment {
        return this.groups.get(p0)
    }



    override fun getChild(group: Int, item: Int): String {

        return when(item) {

            0 -> "${appointmentsActivity.resources.getString(R.string.adapter_expandable_list_hospital)}: ${this.groups[group].hospital}"
            1 -> "${appointmentsActivity.resources.getString(R.string.adapter_expandable_list_doctor)}: ${this.groups[group].doctor}"
            2 -> "${appointmentsActivity.resources.getString(R.string.adapter_expandable_list_date)}: ${this.groups[group].date}"
            3-> "${appointmentsActivity.resources.getString(R.string.adapter_expandable_list_hour)}: ${this.groups[group].hour}"
            4 -> "${appointmentsActivity.resources.getString(R.string.adapter_expandable_list_room)}: ${this.groups[group].room}"
            5 -> "${appointmentsActivity.resources.getString(R.string.adapter_expandable_list_reason)}: ${this.groups[group].reason}"
            else -> ""


        }

    }

    override fun getGroupId(p0: Int):Long  {
        return p0.toLong()
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return p1.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(p0: Int, p1: Boolean, p2: View?, p3: ViewGroup?): View {
        var p2 = p2
        var appointment = getGroup(p0)
        if(p2 == null) {
            val layoutInflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            p2 = layoutInflater.inflate((R.layout.layout_list_group_appointments), null)

        }



        var text:TextView = p2!!.findViewById(R.id.parent_list)
        text.setText("${appointmentsActivity.resources.getString(R.string.adapter_expandable_list_appointment)} ${p0+1} - ${appointment.hour}")




            p2.setOnClickListener {

                if(appointmentsActivity.tabLayoutAppointments!!.getTabAt(1)!!.isSelected) {

                groupClickListener?.invoke(getGroup(p0))

            } else {

                if((p3 as ExpandableListView).isGroupExpanded(p0)) {

                    (p3 as ExpandableListView).collapseGroup(p0)

                } else {

                    (p3 as ExpandableListView).expandGroup(p0, true)

                }


            }

        }


        return p2

    }

    override fun getChildView(p0: Int, p1: Int, p2: Boolean, p3: View?, p4: ViewGroup?): View {
        var p3 = p3
        var textItem = getChild(p0,p1) as String

        if(p3 == null) {

            val layoutInflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            p3 = layoutInflater.inflate(R.layout.layout_list_item_appointments, null)

        }

        var text:TextView = p3!!.findViewById(R.id.child_list)
        text.setText(textItem)



        return p3


    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        return true
    }

    fun setOnGroupClickListener(clickListener:(group:Appointment)->Unit) {

        groupClickListener = clickListener

    }


}