package eu.weberandreas.birthdayplaylist.service

import eu.weberandreas.birthdayplaylist.model.Chart
import eu.weberandreas.birthdayplaylist.repository.ChartRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ChartService(@Autowired val repository: ChartRepository) {
    fun chartByDate(date: String): Chart? {
        return repository.findByDate(date)
    }
}