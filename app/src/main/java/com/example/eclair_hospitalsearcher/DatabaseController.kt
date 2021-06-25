package com.example.eclair_hospitalsearcher

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseController (val context: Context):SQLiteOpenHelper(context,"EclairDatabase", null,1){
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE User(id integer PRIMARY KEY AUTOINCREMENT,NAME varchar (50) NOT NULL, email varchar(100) NOT NULL UNIQUE, password varchar(80)NOT NULL, bood varchar(10) NOT NULL, dateOfBirth varchar (10)NOT NULL, city varchar (50)NOT NULL, gender varchar (50)NOT NULL, phone integer NOT NULL)")
        db?.execSQL("CREATE TABLE Appointment(id integer PRIMARY KEY AUTOINCREMENT NOT NULL, hospital varchar(70) NOT NULL, doctor varchar (50) NOT NULL, date varchar (100) NOT NULL, hour varchar(80) NOT NULL, room varchar(10) NOT NULL, reason varchar(200)NOT NULL)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addUser(user: User){
        val contentValues = ContentValues()
        contentValues.put("email", user.email)
        contentValues.put("password", user.password)
        contentValues.put("name", user.name)
        contentValues.put("dateOfBirth", user.dateOfBirth)
        contentValues.put("city", user.city)
        contentValues.put("gender", user.gender)
        contentValues.put("bloodType", user.bloodType)
        contentValues.put("phone", user.phone)
        writableDatabase.insert("User", null, contentValues)
    }

    fun addAppointment(appointment: Appointment){

        val contentValues = ContentValues()
        contentValues.put("hospital", appointment.hospital)
        contentValues.put("doctor", appointment.doctor)
        contentValues.put("date", appointment.date)
        contentValues.put("hour", appointment.hour)
        contentValues.put("room", appointment.room)
        contentValues.put("reason", appointment.reason)

        writableDatabase.insert("Appointment", null, contentValues)
    }

    fun checkUser(email: String, password: String){
        val cursor = readableDatabase.rawQuery("SELECT id FROM User", arrayOf())
    }

    fun getAppointments():MutableList<Appointment>{

        val cursor = readableDatabase.rawQuery("SELECT * FROM Appointment", arrayOf())
        val listaAppointment = mutableListOf<Appointment>()
        while(cursor.moveToNext()) {

            val hospital = cursor.getString(1)
            val doctor = cursor.getString(2)
            val date = cursor.getString(3)
            val hour = cursor.getString(4)
            val room = cursor.getString(5)
            val reason = cursor.getString(6)
            listaAppointment.add(Appointment(hospital, doctor, date, hour, room, reason))
        }
        cursor.close()
        return listaAppointment
    }



    fun deleteAppointment(appointment: Appointment){
        writableDatabase.delete("Appointment", "date =\"${appointment.date}\" AND hour = \"${appointment.hour}\"", arrayOf())
    }

}