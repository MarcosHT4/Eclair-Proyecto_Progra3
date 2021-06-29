package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ResetPasswordActivity : AppCompatActivity() {

    var buttonSaveNewPassword: Button? = null
    var editTextCurrentPassword: EditText? = null
    var editTextNewPassword:EditText? = null
    var editTextRepeatNewPassword:EditText? = null
    val databaseController = DatabaseController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        var fullName = intent.getStringExtra("fullNameProfile")
        var currentUser = databaseController.getCurrentUser(fullName!!)
        var currentPassword = currentUser.password
        var toast = Toast.makeText(applicationContext, currentPassword, Toast.LENGTH_SHORT)
        toast.show()
        init() //DESGRACIADOOOOOOOOOOOO

        buttonSaveNewPassword = findViewById(R.id.buttonConfirmNewPassword)
        buttonSaveNewPassword?.setOnClickListener {

            if(currentPassword!!.equals(editTextCurrentPassword?.text.toString())) {

                if(editTextNewPassword?.text.toString()!!.equals(editTextRepeatNewPassword?.text.toString())) {

                    val intent = Intent()
                    var newPassword = editTextNewPassword?.text.toString()
                    databaseController.updateUser(currentUser.name, currentUser.email,newPassword,currentUser.bloodType, currentUser.dateOfBirth, currentUser.city,currentUser.gender, currentUser.phone)
                    intent.putExtra("newPassword", newPassword)
                    setResult(RESULT_OK, intent)
                    finish()

                } else {

                    var toast = Toast.makeText(applicationContext, "Las contraseñas no coinciden", Toast.LENGTH_SHORT)
                    toast.show()
                }



            } else {

                var toast = Toast.makeText(applicationContext, "La contraseña no es correcta", Toast.LENGTH_SHORT)
                toast.show()

            }



        }

    }

    fun init() {

        editTextCurrentPassword = findViewById(R.id.editTextCurrentPassword)
        editTextNewPassword = findViewById(R.id.editTextNewPassword)
        editTextRepeatNewPassword = findViewById(R.id.editTextRepeatNewPassword)



    }
}