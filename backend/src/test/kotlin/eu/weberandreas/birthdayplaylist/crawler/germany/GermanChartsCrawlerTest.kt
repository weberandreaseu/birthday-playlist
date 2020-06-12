package eu.weberandreas.birthdayplaylist.crawler.germany

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class GermanChartsCrawlerTest {
    lateinit var crawler: GermanChartsCrawler

    @BeforeEach
    fun setUp() {
        crawler = GermanChartsCrawler()
    }

    @Test
    fun `ensure date in converted to the right crawling url`() {
        val date = LocalDate.of(2003, 10, 1)
        val url = crawler.chartUrl(date)
        assertEquals(url, "https://www.offiziellecharts.de/charts/single/for-date-1064959200000")
    }

    @Test
    fun `ensure top single in october is 'Unrockbar'`() {
        val date = LocalDate.of(2003, 10, 3)
        val single = crawler.numberOneAt(date)
        assertEquals(single.artist, "Die Ärzte")
        assertEquals(single.title, "Unrockbar")
    }
}