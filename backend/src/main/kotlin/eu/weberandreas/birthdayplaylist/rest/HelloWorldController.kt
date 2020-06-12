package eu.weberandreas.birthdayplaylist.rest

import eu.weberandreas.birthdayplaylist.model.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class HelloWorldController {

    @GetMapping("/hello")
    fun helloWorld(): Greeting {
        return Greeting("Hello World")
    }
}
