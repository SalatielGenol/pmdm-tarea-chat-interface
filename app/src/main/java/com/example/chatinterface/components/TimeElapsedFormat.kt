package com.example.chatinterface.components

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

fun getTimeElapsedFormatted(date: Date): String {
    val currentTime = Calendar.getInstance().time
    return when (getDifferenceTimeDefinedByUnit(currentTime, date, 's')) {
        in 0..59 -> getDifferenceTimeDefinedByUnit(currentTime, date, 's').toString() + " s"
        in 60..3599 -> getDifferenceTimeDefinedByUnit(currentTime, date, 'm').toString() + " m"
        in 3600..86399 -> getDifferenceTimeDefinedByUnit(currentTime, date, 'h').toString() + " h"
        else -> SimpleDateFormat("d MMM", Locale.getDefault()).format(date)
    }
}

fun getTimeFormatted(date: Date): String{
    return SimpleDateFormat("H:mm:ss d MMM yyyy", Locale.getDefault()).format(date)
}

private fun getDifferenceTimeDefinedByUnit(
    initialTime: Date,
    finalTime: Date,
    timeUnit: Char
): Long {
    val initialTimeLong = initialTime.time
    val finalTimeLong = finalTime.time
    return when (timeUnit) {
        's' -> TimeUnit.MILLISECONDS.toSeconds(initialTimeLong - finalTimeLong)
        'm' -> TimeUnit.MILLISECONDS.toMinutes(initialTimeLong - finalTimeLong)
        'h' -> TimeUnit.MILLISECONDS.toHours(initialTimeLong - finalTimeLong)
        'd' -> TimeUnit.MILLISECONDS.toDays(initialTimeLong - finalTimeLong)
        else -> Calendar.getInstance().timeInMillis
    }
}