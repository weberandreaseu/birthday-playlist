package eu.weberandreas.birthdayplaylist.util

import java.time.LocalDate
import java.time.Year

class DayInYear private constructor(internal val day: Int, internal val year: Int) {

    fun toDate(): LocalDate {
        val daysInYear = if (Year.isLeap(year.toLong())) 366 else 365
        var shiftedDay = day + if (Year.isLeap(year.toLong())) 60 else 59 // add days of jan & feb
        if (shiftedDay >= daysInYear) { // fix overflow
            shiftedDay -= daysInYear
        }
        return LocalDate.ofYearDay(year, shiftedDay + 1)
    }

    companion object {
        fun of(date: LocalDate): DayInYear {
            // start counting with zero instead of one
            var shiftedDay = date.dayOfYear - 1 - if (date.isLeapYear) 60 else 59 // subtract days of jan & feb
            if (shiftedDay < 0) { // fix underflow
                shiftedDay += if (date.isLeapYear) 366 else 365
            }
            return DayInYear(shiftedDay, date.year)
        }
    }
}