package com.farhanmirza.currencyapp

import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.farhanmirza.currencyapp.robot.MainActivityRobot

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)
    private val mainActivityRobot = MainActivityRobot()
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.farhanmirza.currencyapp", appContext.packageName)
    }

    @Test
    fun whenAppIsLaunchedShowsTitleAndRatesList() {
        // Context of the app under test.
         mainActivityRobot.checkTitleIsShowing()
        mainActivityRobot.checkRatesList(3)
    }
}

