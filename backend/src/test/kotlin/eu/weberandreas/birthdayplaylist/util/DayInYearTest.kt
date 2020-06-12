package eu.weberandreas.birthdayplaylist.util

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate

class DayInYearTest {
    @Test
    internal fun `ensure 1st march is first day in regular year`() {
        val date = LocalDate.of(2019, 3, 1)
        val dayInYear = DayInYear.of(date)
        assertEquals(0, dayInYear.day)
        assertEquals(2019, dayInYear.year)
    }

    @Test
    internal fun `ensure 1st march is first day in leap year`() {
        val date = LocalDate.of(2020, 3, 1)
        val dayInYear = DayInYear.of(date)
        assertEquals(0, dayInYear.day)
        assertEquals(2020, dayInYear.year)
    }

    @Test
    internal fun `ensure 28th of february is 365th day in regular year`() {
        val date = LocalDate.of(2019, 2, 28)
        val dayInYear = DayInYear.of(date)
        assertEquals(365 - 1, dayInYear.day)
        assertEquals(2019, dayInYear.year)
    }

    @Test
    internal fun `ensure 29th of february is 366th day in leap year`() {
        val date = LocalDate.of(2020, 2, 29)
        val dayInYear = DayInYear.of(date)
        assertEquals(366 - 1, dayInYear.day)
        assertEquals(2020, dayInYear.year)
    }

    @Test
    internal fun `serialization works for all days in regular year`() {
        for (dayOfYear in 1..365) {
            val expected = LocalDate.ofYearDay(2019, dayOfYear)
            val actual = DayInYear.of(expected).toDate()
            assertEquals(expected, actual)
        }
    }
    @Test
    internal fun `serialization works for all days in leap year`() {
        for (dayOfYear in 1..366) {
            val expected = LocalDate.ofYearDay(2020, dayOfYear)
            val actual = DayInYear.of(expected).toDate()
            assertEquals(expected, actual)
        }
    }
}