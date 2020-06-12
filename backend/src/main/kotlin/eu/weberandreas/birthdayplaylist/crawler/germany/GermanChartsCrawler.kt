package eu.weberandreas.birthdayplaylist.crawler.germany

import eu.weberandreas.birthdayplaylist.crawler.ChartsCrawler
import eu.weberandreas.birthdayplaylist.model.Song
import java.sql.Timestamp
import java.time.LocalDate

class GermanChartsCrawler : ChartsCrawler {
    private val chartUrl = "https://www.offiziellecharts.de/charts/single/for-date-"

    override fun countryCode(): String {
        return "DE"
    }

    override fun numberOneAt(date: LocalDate): Song {
        TODO("Not yet implemented")
    }

    fun chartUrl(date: LocalDate): String {
        return chartUrl + Timestamp.valueOf(date.atStartOfDay()).time
    }
}