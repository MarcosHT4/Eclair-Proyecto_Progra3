package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ResetPasswordActivity : AppCompatActivity() {

    var buttonSaveNewPassword: Button? = null
    var editTextNewPassword:EditText?=null
    var editTextCurrentPassword:EditText?=null
    var editTextRepeatPassword:EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        var currentPassword = intent.getStringExtra("currentPassword")
        var toast = Toast.makeText(applicationContext, currentPassword, Toast.LENGTH_SHORT)
        toast.show()
        init()

        buttonSaveNewPassword = findViewById(R.id.buttonConfirmNewPassword)
        buttonSaveNewPassword?.setOnClickListener {
            if (currentPassword!!.equals (editTextCurrentPassword?.text.toString())) {

                if (editTextNewPassword?.text.toString()!!
                        .equals(editTextRepeatPassword?.text.toString())
                ) {
                    val intent = Intent()
                    var newPassword = editTextNewPassword?.text.toString()
                    intent.putExtra("newPassword", newPassword)
                    setResult(RESULT_OK, intent)
                    finish()
                } else {
                    var toast = Toast.makeText(
                        applicationContext,
                        "Las contraseñas no coinciden",
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }

            } else {
                var toast = Toast.makeText(
                    applicationContext,
                    "La contraseña no es correcta",
                    Toast.LENGTH_SHORT
                )
                toast.show()
            }
        }
    }



    fun init(){
        editTextCurrentPassword=findViewById(R.id.editTextCurrentPassword)
        editTextNewPassword=findViewById(R.id.editTextNewPassword)
        editTextRepeatPassword=findViewById(R.id.editTextRepeatNewPassword)

    }

}