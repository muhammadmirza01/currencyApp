package com.farhanmirza.currencyapp.robot

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.farhanmirza.currencyapp.R

class MainActivityRobot {
    fun checkTitleIsShowing() {
        Espresso.onView(ViewMatchers.withId(R.id.rates_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Currency Rates")))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    fun checkRatesList(items: Int) {
        Espresso.onView(ViewMatchers.withId(R.id.rates_list))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
            .check(ViewAssertions.matches(hasItemsCount(items)))
    }
}