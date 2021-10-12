package com.farhanmirza.currencyapp.api
import com.farhanmirza.currencyapp.data.RateResponse

interface  RatesAPI {
   suspend fun fetchRates() : RateResponse
}


