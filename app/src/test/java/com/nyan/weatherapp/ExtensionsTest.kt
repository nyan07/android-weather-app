package com.nyan.weatherapp

import com.nyan.weatherapp.extensions.toDateString
import org.junit.Test

import org.junit.Assert.*
import java.text.DateFormat

class ExtensionsTest {

    @Test fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000L.toDateString())
    }

    @Test fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015", 1445275635000L.toDateString(DateFormat.FULL))
    }
}
