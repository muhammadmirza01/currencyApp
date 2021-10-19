package com.farhanmirza.currencyapp.api
import com.farhanmirza.currencyapp.data.RateResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// Rates URL:  https://www.currency-api.com/rates

interface  RatesAPI {
   @GET("rates.json")
   suspend fun fetchRates() : RateResponse

   companion object {
      val instance : RatesAPI by lazy {
         create()
      }
      var BASE_URL = "https://www.currency-api.com/rates"
      fun create() : RatesAPI {
         val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
         return retrofit.create(RatesAPI::class.java)
      }
   }
}


