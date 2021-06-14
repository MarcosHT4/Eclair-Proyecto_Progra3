package com.example.eclair_hospitalsearcher

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class EmergencyActivity : AppCompatActivity() {
    var buttonSOS:ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_emergency)
        buttonSOS = findViewById(R.id.imageView_SOS_Button)
        showDialog()

        buttonSOS?.setOnClickListener {

            val intent = Intent(this, EmergencyOnCallActivity::class.java)
            startActivity(intent)

        }


    }

    fun showDialog() {

        val createDialog = AlertDialog.Builder(this)
        createDialog.setTitle("Instructions")
        createDialog.setMessage("If you're in need of an ambulance, press the button, and we'll make sure an ambulance arrives in 30 minutes tops.")
        createDialog.setPositiveButton("AGREE", DialogInterface.OnClickListener{dialog, which ->

            dialog.dismiss()


        })
        val dialog = createDialog.create()
        dialog.show()

    }


}