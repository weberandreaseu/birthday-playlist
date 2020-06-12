package eu.weberandreas.birthdayplaylist.rest

import eu.weberandreas.birthdayplaylist.model.Chart
import eu.weberandreas.birthdayplaylist.service.ChartService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ChartController(@Autowired val service: ChartService) {

    @GetMapping("/charts/{date}")
    fun charts(@PathVariable date: String): Chart? {
        return service.chartByDate(date)
    }
}
