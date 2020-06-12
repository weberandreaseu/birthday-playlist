package eu.weberandreas.birthdayplaylist.crawler.germany

import eu.weberandreas.birthdayplaylist.crawler.ChartsCrawler
import eu.weberandreas.birthdayplaylist.model.Song
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import java.sql.Timestamp
import java.time.LocalDate

class GermanChartsCrawler : ChartsCrawler {
    private val chartUrl = "https://www.offiziellecharts.de/charts/single/for-date-"

    override fun countryCode(): String {
        return "DE"
    }

    override fun numberOneAt(date: LocalDate): Song {
        val connection = Jsoup.connect(chartUrl(date))
        val document = connection.get()
        val elements = document.select("table.table.chart-table tbody :first-child td.ch-info")
        val foundArtist: Element? = elements.select(".info-artist").first()
        val artist = foundArtist?: throw RuntimeException("No artist for for top song on $date")
        val foundTitle: Element? = elements.select(".info-title").first()
        val title = foundTitle?: throw RuntimeException("No title for for top song on $date")
        return Song(title.text(), artist.text())
    }

    fun chartUrl(date: LocalDate): String {
        return chartUrl + Timestamp.valueOf(date.atStartOfDay()).time
    }
}