package com.example.eclair_hospitalsearcher

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
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

            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tell:165"))
            startActivity(intent)
        }


    }

    fun showDialog() {

        val createDialog = AlertDialog.Builder(this)
        createDialog.setTitle(resources.getString(R.string.instructions_title_emergency))
        createDialog.setMessage(resources.getString(R.string.instructions_body_emergency))
        createDialog.setPositiveButton("AGREE", DialogInterface.OnClickListener{dialog, which ->

            dialog.dismiss()


        })
        val dialog = createDialog.create()
        dialog.show()

    }


}