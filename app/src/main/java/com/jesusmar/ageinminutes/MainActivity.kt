package com.jesusmar.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSelecteDate.setOnClickListener {
            clickDatePicker()
        }
    }

    fun clickDatePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val month = myCalendar.get(Calendar.MONTH)

        val dpd = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                    setInMinutesLabel(year, month, dayOfMonth)
            }
            , year
            , month
            , day)

        dpd.datePicker.setMaxDate(Date().time - 86400000)
        dpd.show()
    }

    private fun setInMinutesLabel(year: Int, month: Int, dayOfMonth: Int) {
        val selectedDateAsString: String = "${dayOfMonth}/${month+1}/${year}"
        textBirthday.text = selectedDateAsString
        textMinutes.text = DateCalculator().calculteAgeInMinutes(selectedDateAsString)
    }
}
