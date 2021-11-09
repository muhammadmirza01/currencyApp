package com.farhanmirza.currencyapp.robot

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.farhanmirza.currencyapp.R
import com.farhanmirza.currencyapp.viewmatchers.RecycleViewMatchers

class MainActivityRobot {
    fun checkTitleIsShowing() {
        Espresso.onView(ViewMatchers.withId(android.R.id.text1))
            .check(ViewAssertions.matches(ViewMatchers.withText("CurrencyApp")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun checkRatesList(items: Int) {
        Espresso.onView(ViewMatchers.withId(R.id.rates_list))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches( RecycleViewMatchers.hasItemCount(items)))
    }
}