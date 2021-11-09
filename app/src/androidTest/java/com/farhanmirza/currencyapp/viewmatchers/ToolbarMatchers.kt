package com.farhanmirza.currencyapp.viewmatchers

import android.view.View
import android.widget.Toolbar
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.children
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher

object ToolbarMatchers {
    @JvmStatic
    fun hasChildWithText(text: String): Matcher<View> {
        return object : BoundedMatcher<View, Toolbar>(
            Toolbar::class.java
        ) {

            override fun describeTo(description: Description) {
                description.appendText("has child with $text")
            }

            override fun matchesSafely(view: Toolbar): Boolean {
                val list = view.children
                    .filter { it is AppCompatTextView && it.text.toString() == text }

                return true
            }
        }
    }
}
