package com.example.demo.hystrixThread

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@RestController()
class HystrixThreadController(val restTemplateBuilder: RestTemplateBuilder) {
    val template = restTemplateBuilder
    .rootUri("http://localhost:3000/")
    .build()

    @GetMapping("/request")
    fun launchRequest(): String {
      val command = ThreadCommand(template)
    	return command.execute()
		}
}
