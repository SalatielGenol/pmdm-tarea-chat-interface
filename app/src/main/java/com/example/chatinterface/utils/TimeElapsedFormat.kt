package com.example.chatinterface.utils

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

fun getTimeElapsedFormatted(date: LocalDateTime): String {
    val currentTime = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("d MMM")
    return when (getDifferenceTimeDefinedByUnit(currentTime, date, 's')) {
        in 0..59 -> getDifferenceTimeDefinedByUnit(currentTime, date, 's').toString() + " s"
        in 60..3599 -> getDifferenceTimeDefinedByUnit(currentTime, date, 'm').toString() + " m"
        in 3600..86399 -> getDifferenceTimeDefinedByUnit(currentTime, date, 'h').toString() + " h"
        else -> date.format(formatter)
    }
}

fun getTimeFormatted(date: LocalDateTime): String{
    val formatter = DateTimeFormatter.ofPattern("H:mm:ss d MMM yyyy")
    return date.format(formatter)
}

private fun getDifferenceTimeDefinedByUnit(
    initialTime: LocalDateTime,
    finalTime: LocalDateTime,
    timeUnit: Char
): Long {
    val initialTimeLong = initialTime.toEpochSecond(ZoneOffset.UTC)
    val finalTimeLong = finalTime.toEpochSecond(ZoneOffset.UTC)
    return when (timeUnit) {
        's' -> initialTimeLong - finalTimeLong
        'm' -> TimeUnit.SECONDS.toMinutes(initialTimeLong - finalTimeLong)
        'h' -> TimeUnit.SECONDS.toHours(initialTimeLong - finalTimeLong)
        'd' -> TimeUnit.SECONDS.toDays(initialTimeLong - finalTimeLong)
        else -> LocalDateTime.now().toEpochSecond(ZoneOffset.UTC)
    }
}