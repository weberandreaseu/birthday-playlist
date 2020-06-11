package eu.weberandreas.birthdayplaylist.rest

import org.hamcrest.CoreMatchers.`is`
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(HelloWorldController::class)
internal class HelloWorldControllerTest {

    @Autowired
    private lateinit var mock: MockMvc

    @Test
    internal fun testGetHelloWorld() {
        mock.perform(get("/api/hello")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("greeting", `is`("Hello World")))
    }
}