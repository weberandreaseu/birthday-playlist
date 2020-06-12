package eu.weberandreas.birthdayplaylist.repository

import eu.weberandreas.birthdayplaylist.model.Chart
import org.springframework.data.repository.CrudRepository

interface ChartRepository : CrudRepository<Chart, Long> {
    fun findByDate(date: String): Chart?
}