package com.farhanmirza.currencyapp

import org.junit.Test
import org.junit.Assert.*

class APIUnitTest {
    @Test
    fun `when request is made returns base rates`() {
        val testSubject = RatesAPI()
        val result = testSubject.fetchBaseRates()
        assertNotNull(result)
    }

    @Test
    fun `when request is made returns valid items`() {
        val testSubject = RatesAPI()
        val result = testSubject.fetchBaseRates()
        assertTrue(result[0] is Rate)
        assertEquals(result[0].name, "Dollar")
    }

}


class RatesAPI {
    fun fetchBaseRates()  = listOf(Rate(name = "Dollar"))
}

// to hold data...
data class Rate (val name: String)