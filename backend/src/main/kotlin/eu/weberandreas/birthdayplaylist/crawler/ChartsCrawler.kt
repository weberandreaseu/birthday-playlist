package eu.weberandreas.birthdayplaylist.crawler

import eu.weberandreas.birthdayplaylist.model.Song
import java.time.LocalDate

interface ChartsCrawler {

    fun countryCode(): String

    fun numberOneAt(date: LocalDate): Song

}