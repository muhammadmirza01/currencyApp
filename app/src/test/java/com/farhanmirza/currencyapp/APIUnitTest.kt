package com.farhanmirza.currencyapp


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import io.mockk.MockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule

class APIUnitTest {
//    @Test
//    fun `when request is made returns base rates`() {
//        val testSubject = RatesAPI()
//        val result = testSubject.fetchBaseRates()
//        assertNotNull(result)
//    }
//
//    @Test
//    fun `when request is made returns valid items`() {
//        val testSubject = RatesAPI()
//        val result = testSubject.fetchBaseRates()
//        assertTrue(result is RateResponse)
//        assertEquals(result.base, "EURO")
//    }

    @get: Rule
    val rule = InstantTaskExecutorRule()

    @Test
     fun `testing when we retrieve list of rates and send a signal to display`() {
         val testSubject = RatesViewModel()
         val observer: Observer<RateResponse> = mockk()
         testSubject.rates.observeForever(observer)
         testSubject.fetchRates()
         verify {observer.onChanged(any())}
     }

}

class RatesViewModel: ViewModel() {
     private val _rates = MutableLiveData<RateResponse>()
     val rates: LiveData<RateResponse> = _rates

    fun fetchRates() {

     }
}


interface RatesAPI {
    fun fetchBaseRates()  ////RateResponse(base = "EURO",date = "21 Sep 2021",rates = hashMapOf())
}

// to hold data...
data class RateResponse (val base: String, val date: String, val rates: HashMap<String, Double>)