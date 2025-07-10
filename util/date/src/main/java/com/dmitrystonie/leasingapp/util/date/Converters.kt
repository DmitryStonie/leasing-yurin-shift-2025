package com.dmitrystonie.leasingapp.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun dateToDay(date: Long): String {
    val date = Date(date)
    val format = SimpleDateFormat("dd", Locale.US)
    return format.format(date)
}

fun dateToMonth(date: Long): String {
    val date = Date(date)
    return SimpleDateFormat("MMMM", Locale.getDefault()).format(date)
}

fun dateToYear(date: Long): String {
    val date = Date(date)
    return SimpleDateFormat("yyyy", Locale.getDefault()).format(date)
}

fun daysDuration(begin: Long, end: Long): Int{
    return ((end - begin) / (1000*60*60*24)).toFloat().toInt()
}

fun dateToDate(date: Long): String{
    val date = Date(date)
    return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date)
}

