package com.farhanmirza.currencyapp


import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.farhanmirza.currencyapp.api.RatesAPI
import com.farhanmirza.currencyapp.data.RateResponse
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.*
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*

@ExperimentalCoroutinesApi
open class RatesAppUnitTests {
    @get: Rule
    val rule = InstantTaskExecutorRule()
    companion object {

        val testDispatcher = TestCoroutineDispatcher()
        @BeforeClass
        @JvmStatic
        fun setupUnitTests() {
            Dispatchers.setMain(testDispatcher)
        }

        @AfterClass
        @JvmStatic
        fun breakDownUnitTests() {
            Dispatchers.resetMain()
            testDispatcher.cleanupTestCoroutines()
        }
    }
}

@ExperimentalCoroutinesApi
class RatesViewModelUnitTests: RatesAppUnitTests() {

    @Test
     fun `testing when we retrieve list of rates and send a signal to display`() {
         val expectedData = RateResponse(base = "EURO",date = "21 Sep 2021",rates = hashMapOf())
         val mockAPI = mockk<RatesAPI>()
         coEvery {
             mockAPI.fetchRates()
         } returns expectedData
         val testSubject = RatesListViewModel(ratesAPI = mockAPI)
         val observer: Observer<RateResponse> = mockk(relaxed = true)
         testSubject.rates.observeForever(observer)
         testSubject.fetchRates()
         verify {observer.onChanged(expectedData) }
     }


    @Test
    fun `testing when we retrieve list of rates with retorfit`() {

        TestCoroutineScope().launch {
            val ratesInterface = RatesAPI.create().fetchRates()
            print(ratesInterface.rates)
        }
    }

}

// base URL =  https://www.currency-api.com/
// rates URL = https://www.currency-api.com/rates