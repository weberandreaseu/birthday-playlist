package eu.weberandreas.birthdayplaylist.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "chart")
data class Chart(val date: String, @Id @GeneratedValue var id: Long? = null)