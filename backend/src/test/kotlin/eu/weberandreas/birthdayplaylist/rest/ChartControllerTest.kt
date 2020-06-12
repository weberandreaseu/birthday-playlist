package eu.weberandreas.birthdayplaylist.rest

import eu.weberandreas.birthdayplaylist.model.Chart
import eu.weberandreas.birthdayplaylist.service.ChartService
import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@WebMvcTest(ChartController::class)
internal class ChartControllerTest {

    @Autowired
    private lateinit var mock: MockMvc

    @MockBean
    private lateinit var service: ChartService

    @Test
    internal fun `get chars from 2020-05-06`() {
        given(service.chartByDate("2020-05-06")).willReturn(Chart("2020-05-06"))
        mock.perform(get("/api/charts/2020-05-06")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("date", `is`("2020-05-06")))
    }
}