package com.example.eclair_hospitalsearcher

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseController(val context: Context):SQLiteOpenHelper(context, "EclairDatabase", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("CREATE TABLE User(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name varchar(50) NOT NULL, email varchar(100) NOT NULL UNIQUE, password varchar(80) NOT NULL, blood INTEGER NOT NULL, dateOfBirth varchar(10) NOT NULL, city varchar(50) NOT NULL, gender varchar(50) NOT NULL, phone varchar(100) NOT NULL, username varchar (50))")
        db?.execSQL("CREATE TABLE Appointment(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, hospital varchar(70) NOT NULL, doctor VARCHAR(50) NOT NULL, date VARCHAR(100) NOT NULL, hour VARCHAR(80) NOT NULL, room VARCHAR(10) NOT NULL, reason VARCHAR(200) NOT NULL)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun addUser(user:User) {

        val contentValues = ContentValues()
        contentValues.put("email", user.email)
        contentValues.put("password", user.password)
        contentValues.put("name", user.name)
        contentValues.put("dateOfBirth", user.dateOfBirth)
        contentValues.put("city", user.city)
        contentValues.put("gender", user.gender)
        contentValues.put("blood", user.bloodType)
        contentValues.put("phone", user.phone)
        contentValues.put("username", user.userName)


        writableDatabase.insert("User", null, contentValues)

    }

    fun addAppointment(appointment: Appointment) {

        val contentValues = ContentValues()
        contentValues.put("hospital", appointment.hospital)
        contentValues.put("doctor", appointment.doctor)
        contentValues.put("date", appointment.date)
        contentValues.put("hour", appointment.hour)
        contentValues.put("room", appointment.room)
        contentValues.put("reason", appointment.reason)

        writableDatabase.insert("Appointment", null, contentValues)

    }

    fun checkUser(emailInput:String, passwordInput:String, userNameInput:String):Boolean {

        val cursor = readableDatabase.rawQuery("SELECT * FROM User WHERE email = \"${emailInput}\" AND password = \"${passwordInput}\" AND username = \"${userNameInput}\" " , arrayOf())
        cursor.moveToFirst()
        val counter = cursor.getCount()
        cursor.close()
        if(counter==1) {

            return true

        } else {

            return false

        }



    }

    fun getNameUser(userNameInput:String):String {

        val cursor = readableDatabase.rawQuery("SELECT * FROM User WHERE userName = \"${userNameInput}\"", arrayOf())
        cursor.moveToFirst()
        val name = cursor.getString(1)
        return name


    }

    fun getCurrentUser(nameInput:String):User {

        val cursor = readableDatabase.rawQuery("SELECT * FROM User WHERE name = \"${nameInput}\" " , arrayOf())
        cursor.moveToFirst()
        val currentName = cursor.getString(1)
        val currentEmail = cursor.getString(2)
        val currentPassword = cursor.getString(3)
        val currentBlood:Int = cursor.getInt(4)
        val currentDateOfBirth = cursor.getString(5)
        val currentCity = cursor.getString(6)
        val currentGender = cursor.getString(7)
        val currentPhone = cursor.getString(8)
        val currentUserName = cursor.getString(9)

        return User(currentEmail, currentPassword, currentName, currentDateOfBirth, currentCity, currentGender, currentBlood,currentPhone,currentUserName)

    }

    fun updateUser(name:String,newEmail:String, newPassword:String, newBlood:Int, newDateOfBirth:String, newCity:String, newGender:String, newPhone:String) {

        val contentValues = ContentValues()
        contentValues.put("dateOfBirth", newDateOfBirth)
        contentValues.put("city", newCity)
        contentValues.put("gender", newGender)
        contentValues.put("blood", newBlood)
        contentValues.put("phone", newPhone)
        contentValues.put("email", newEmail)
        contentValues.put("password", newPassword)

        writableDatabase.update("User", contentValues, "name = \"${name}\"", arrayOf())


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
            listaAppointment.add(Appointment(hospital, doctor, date, hour, room ,reason))

        }

        cursor.close()
        return listaAppointment

    }





    fun deleteAppointment(appointment: Appointment) {

        writableDatabase.delete("Appointment", "date =\"${appointment.date}\" AND hour=\"${appointment.hour}\"", arrayOf())

    }
}