package com.example.eclair_hospitalsearcher

import android.content.Intent
import android.graphics.Color.red
import android.os.Build

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.util.*

class LogUpActivity : AppCompatActivity() {

    var buttonLogin:Button? = null
    var buttonSignUp: Button? = null
    var switchLanguage:Switch?  = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_up)
        buttonLogin = findViewById(R.id.buttonLogIn)
        buttonSignUp = findViewById(R.id.buttonSignUp)
        switchLanguage = findViewById(R.id.switchLanguage)

        switchLanguage?.setOnCheckedChangeListener { buttonView, isChecked ->

            if(isChecked) {

                val config = resources.configuration
                val lang = "es"
                val locale = Locale(lang)
                Locale.setDefault(locale)
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

                    config.setLocale(locale)

                } else {

                    config.locale = locale

                }

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                    createConfigurationContext(config)

                }

                resources.updateConfiguration(config, resources.displayMetrics)

            } else {

                val config = resources.configuration
                val lang = "en"
                val locale = Locale(lang)
                Locale.setDefault(locale)
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {

                    config.setLocale(locale)

                } else {

                    config.locale = locale

                }

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                    createConfigurationContext(config)

                }

                resources.updateConfiguration(config, resources.displayMetrics)

            }

        }




        buttonLogin!!.setOnClickListener {

            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)

        }

        buttonSignUp!!.setOnClickListener {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)

        }


    }
}