package com.example.savepoint.core.util

import java.text.NumberFormat
import java.util.Locale

private const val USD_TO_MXN_RATE = 17.50

private val mxnFormatter: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "MX"))

fun Double.toMxnPrice(): String {
    val mxnAmount = this * USD_TO_MXN_RATE
    return mxnFormatter.format(mxnAmount)
}
