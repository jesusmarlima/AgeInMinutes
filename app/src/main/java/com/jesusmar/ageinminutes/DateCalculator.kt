package com.jesusmar.ageinminutes

import java.text.SimpleDateFormat


class DateCalculator {

    val sdf = SimpleDateFormat("dd/MM/yyyy")
    val today = sdf.parse(sdf.format(System.currentTimeMillis()))

    fun calculteAgeInMinutes(selectedDate: String): String {
        val selectedDate = sdf.parse(selectedDate)
        val InMinutes = (today.time / 60000) - (selectedDate.time / 60000)
        return "${InMinutes}"
    }
}