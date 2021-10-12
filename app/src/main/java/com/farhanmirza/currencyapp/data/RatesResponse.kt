package com.farhanmirza.currencyapp.data

data class RateResponse (val base: String, val date: String, val rates: HashMap<String, Double>)