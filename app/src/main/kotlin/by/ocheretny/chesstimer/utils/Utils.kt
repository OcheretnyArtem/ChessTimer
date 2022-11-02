package by.ocheretny.chesstimer.utils

import com.chargemap.compose.numberpicker.Hours

private const val MINUTES_IN_HOUR = 60

fun Hours.toInt() = minutes + hours * MINUTES_IN_HOUR
