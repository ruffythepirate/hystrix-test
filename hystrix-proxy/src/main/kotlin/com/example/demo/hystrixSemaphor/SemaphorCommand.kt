package com.example.demo.hystrixSemaphor

import com.netflix.hystrix.HystrixCommand
import com.netflix.hystrix.HystrixCommandGroupKey
import org.springframework.web.client.RestTemplate;

class SemaphorCommand(val restTemplate: RestTemplate) : HystrixCommand<String>(HystrixCommandGroupKey.Factory.asKey("semaphor")) {

	override fun run(): String {
		try {
			println("starting request")
			val response = restTemplate.getForObject<String>("http://localhost:3000/delay-me/5000", String::class.java)
			println("request request ${response}")
			return response ?: "empty"
		} catch (e: Throwable) {
			println("Exception occurred ${e}");
			throw e
		}
	}

	override fun getFallback(): String {
		return "Fallback"
	}




}
