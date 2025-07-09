package com.dmitrystonie.leasingapp.util

import com.dmitrystonie.leasingapp.car.domain.Rent
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun Rent.fromToDay(): String {
    val date = Date(this.startDate)
    val format = SimpleDateFormat("dd", Locale.US)
    return format.format(date)
}

fun Rent.fromToMonth(): String {
    val date = Date(this.startDate)
    return SimpleDateFormat("MMMM", Locale.getDefault()).format(date)
}

fun Rent.fromToYear(): String {
    val date = Date(this.startDate)
    return SimpleDateFormat("yyyy", Locale.getDefault()).format(date)
}

fun Rent.toToDay(): String {
    val date = Date(this.endDate)
    val format = SimpleDateFormat("dd", Locale.US)
    return format.format(date)
}

fun Rent.toToMonth(): String {
    val date = Date(this.endDate)
    return SimpleDateFormat("MMMM", Locale.getDefault()).format(date)
}

fun Rent.toToYear(): String {
    val date = Date(this.endDate)
    return SimpleDateFormat("yyyy", Locale.getDefault()).format(date)
}

fun Rent.daysDuration(): Int{
    return ((this.endDate - this.startDate) / (1000*60*60*24)).toFloat().toInt()
}

fun Rent.fromDate(): String{
    val date = Date(this.startDate)
    return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date)
}

fun Rent.toDate(): String{
    val date = Date(this.endDate)
    return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date)
}