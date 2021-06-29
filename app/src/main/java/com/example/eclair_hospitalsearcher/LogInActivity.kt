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
        var emailLogIn = intent.getStringExtra("emailSignUp")
        var passwordLogIn = intent.getStringExtra("passwordSignUp")
        var fullNameLogIn = intent.getStringExtra("fullNameSignUp")
        var dateOfBirthLogIn = intent.getStringExtra("dateOfBirthSignUp")
        var cityLogIn = intent.getStringExtra("citySignUp")
        var genderLogIn = intent.getStringExtra("genderSignUp")
        init()
        buttonLogIn = findViewById(R.id.button2LogIn)

        buttonLogIn?.setOnClickListener {

            if(databaseController.checkUser(logInInputEmail?.text.toString(), logInInputPassword?.text.toString(), logInInputUserName?.text.toString())) {

                val intent = Intent(this, MenuActivity::class.java)

                if(fullNameLogIn==null) {

                    fullNameLogIn = databaseController.getNameUser(logInInputUserName?.text.toString())

                }

                val userTest = databaseController.getCurrentUser(fullNameLogIn!!)


                intent.putExtra("emailLogIn", userTest.email)
                intent.putExtra("passwordLogIn", userTest.password)
                intent.putExtra("fullNameMenu", userTest.name)


                startActivity(intent)
            } else {

                var toast = Toast.makeText(applicationContext, "E-mail,contraseña o usuario incorrectos", Toast.LENGTH_SHORT)
                toast.show()



            }



        }

    }

    fun init() {

        logInInputEmail = findViewById(R.id.editTextLogInEmail)
        logInInputPassword = findViewById(R.id.editTextLogInPassword)
        logInInputUserName = findViewById(R.id.editTextUserNameLogIn)

    }



}