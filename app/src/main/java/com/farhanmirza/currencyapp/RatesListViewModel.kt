package com.farhanmirza.currencyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farhanmirza.currencyapp.api.RatesAPI
import com.farhanmirza.currencyapp.data.RateResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class RatesListViewModel (private val ratesAPI: RatesAPI) : ViewModel() {
    private val _rates = MutableLiveData<RateResponse>()
    val rates: LiveData<RateResponse> = _rates

    fun fetchRates() {
         viewModelScope.launch {
           withContext(Dispatchers.IO) {
               _rates.postValue(ratesAPI.fetchRates())
           }
         }
        //RateResponse(base = "EURO",date = "21 Sep 2021",rates = hashMapOf())
    }
}

