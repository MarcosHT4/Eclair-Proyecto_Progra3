package com.example.eclair_hospitalsearcher

import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class AppointmentCreationActivity : AppCompatActivity() {

    var textViewAppointmentHospitalData: TextView? = null
    var textViewAppointmentDoctorData: TextView? = null
    var editTextAppointmentDateData: EditText? = null
    var editTextAppointmentHourData: EditText? = null
    var textViewAppointmentRoomData: TextView? = null
    var spinnerAppointmentReasonData: Spinner? = null
    var buttonCreateAppointmentData: Button? = null
    val databaseController = DatabaseController(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointment_creation)
        init()
        var hospitalNameData = intent.getStringExtra("nameHospital")
        var doctorNameData = intent.getStringExtra("nameDoctor")
        var roomData = intent.getStringExtra("roomAppointment")

        textViewAppointmentHospitalData?.setText(hospitalNameData)
        textViewAppointmentDoctorData?.setText(doctorNameData)
        textViewAppointmentRoomData?.setText(roomData)
        editTextAppointmentDateData?.setOnClickListener {
            showCalendar()
        }

        editTextAppointmentHourData?.setOnClickListener {
            val calendar = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener{timePicker, hour, minute ->

                calendar.set(Calendar.HOUR, hour)
                calendar.set(Calendar.MINUTE, minute)
                editTextAppointmentHourData?.setText(SimpleDateFormat("HH:mm").format(calendar.time))


            }
            TimePickerDialog(this, timeSetListener,calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true).show()
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.reason_appointments,
            android.R.layout.simple_spinner_item

        ).also { adapter ->

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerAppointmentReasonData?.adapter = adapter

        }
        buttonCreateAppointmentData?.setOnClickListener {
            if (isTextEmpty(editTextAppointmentDateData!!) || isTextEmpty(
                    editTextAppointmentHourData!!)) {
                var toast = Toast.makeText(this, resources.getString(R.string.text_fields_not_filled), Toast.LENGTH_SHORT).show()
            } else {


            var sendHospitalName = textViewAppointmentHospitalData?.text.toString()
            var sendDoctorName = textViewAppointmentDoctorData?.text.toString()
            var sendDate = editTextAppointmentDateData?.text.toString()
            var sendHour = editTextAppointmentHourData?.text.toString()
            var sendRoom = textViewAppointmentRoomData?.text.toString()
            var sendReason = spinnerAppointmentReasonData?.selectedItem.toString()

            val sendAppointment = Appointment(
                sendHospitalName,
                sendDoctorName,
                sendDate,
                sendHour,
                sendRoom,
                sendReason
            )
            databaseController.addAppointment(sendAppointment)
            val intent = Intent(this, AppointmentsActivity::class.java)
            startActivity(intent)
            finish()
        }

        }

    }
    fun showCalendar(){
        val datePicker = DatePickerFragment({day, month, year -> onDateSelected(day, month, year)})
        datePicker.show(supportFragmentManager, "datePicker")
    }
    fun onDateSelected(day:Int,month:Int,year:Int){
        editTextAppointmentDateData?.setText("$day/${month+1}/$year")
    }
    fun init (){
        textViewAppointmentHospitalData = findViewById(R.id.textViewAppointmentsHospitalData )
        textViewAppointmentDoctorData = findViewById(R.id.textViewAppointmentsDoctorData)
        editTextAppointmentDateData = findViewById(R.id.textViewAppointmentsDateData)
        editTextAppointmentHourData = findViewById(R.id.textViewAppointmentsHourData)
        textViewAppointmentRoomData = findViewById(R.id.textViewAppointmentsRoomData)
        spinnerAppointmentReasonData = findViewById(R.id.spinnerAppointmentsReasonData)
        buttonCreateAppointmentData = findViewById(R.id.buttonSendAppointment)
    }
    private fun isTextEmpty(et:EditText):Boolean {

        if(et.text.toString().trim().length>0) {

            return false

        }

        return true


    }
}