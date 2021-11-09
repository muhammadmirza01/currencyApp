package com.farhanmirza.currencyapp.data

data class RateResponse (
    val base: String,
    val date: String,
    val rates: HashMap<String, Double>
    )

fun RateResponse.GetRatesArray() : List<String> {
    return rates.values.map{ it.toString()}
}
