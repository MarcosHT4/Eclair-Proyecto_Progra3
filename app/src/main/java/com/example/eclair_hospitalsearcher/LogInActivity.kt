package com.example.eclair_hospitalsearcher

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.*
import android.widget.Spinner

class LogInActivity : AppCompatActivity() {

    var buttonLogIn: Button? = null
    var logInInputEmail: EditText? = null
    var logInInputPassword: EditText? = null

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
            if (emailLogIn!!.equals(logInInputEmail?.text.toString()) && passwordLogIn.equals(logInInputPassword?.text.toString())){

                val intent = Intent(this, MenuActivity::class.java)

                intent.putExtra("emailLogIn", emailLogIn)
                intent.putExtra("passwordLogIn", passwordLogIn)
                intent.putExtra("fullNameLogIn", fullNameLogIn)
                intent.putExtra("dateOfBirthLogIn", dateOfBirthLogIn)
                intent.putExtra("cityLogIn", cityLogIn)
                intent.putExtra("genderLogIn", genderLogIn)
                startActivity(intent)


            } else {

                var toast = Toast.makeText(applicationContext,"E-mail o contraseña incorrecta",Toast.LENGTH_SHORT)
                toast.show()

            }

        }



    }
    fun init(){
        logInInputEmail = findViewById(R.id.editTextLogInEmail)
        logInInputPassword = findViewById(R.id.editTextLogInPassword)
    }

}
