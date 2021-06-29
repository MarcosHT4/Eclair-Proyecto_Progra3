package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.*
import android.widget.Spinner

class LogInActivity : AppCompatActivity() {

    var buttonLogIn: Button? = null
    var logInInputEmail:EditText? = null
    var logInInputPassword:EditText? = null
    var databaseController = DatabaseController(this)
    var logInInputUserName:EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        var fullNameLogIn = intent.getStringExtra("fullNameSignUp")
        init()
        buttonLogIn = findViewById(R.id.button2LogIn)

        buttonLogIn?.setOnClickListener {
            if (isTextEmpty(logInInputEmail!!) || isTextEmpty(logInInputPassword!!) || isTextEmpty(logInInputPassword!!)) {
                var toast = Toast.makeText(this, resources.getString(R.string.text_fields_not_filled), Toast.LENGTH_SHORT).show()
            } else {
            if (databaseController.checkUser(
                    logInInputEmail?.text.toString(),
                    logInInputPassword?.text.toString(),
                    logInInputUserName?.text.toString()
                )
            ) {

                val intent = Intent(this, MenuActivity::class.java)

                if (fullNameLogIn == null) {

                    fullNameLogIn =
                        databaseController.getNameUser(logInInputUserName?.text.toString())

                }

                val userTest = databaseController.getCurrentUser(fullNameLogIn!!)

                intent.putExtra("fullNameMenu", userTest.name)


                startActivity(intent)
            } else {

                var toast = Toast.makeText(
                    applicationContext,
                    "E-mail,contraseña o usuario incorrectos",
                    Toast.LENGTH_SHORT
                )
                toast.show()


            }
        }



        }

    }

    fun init() {

        logInInputEmail = findViewById(R.id.editTextLogInEmail)
        logInInputPassword = findViewById(R.id.editTextLogInPassword)
        logInInputUserName = findViewById(R.id.editTextUserNameLogIn)

    }
    private fun isTextEmpty(et:EditText):Boolean {

        if(et.text.toString().trim().length>0) {

            return false

        }

        return true


    }



}