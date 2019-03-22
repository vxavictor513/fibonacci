package com.example.fibonacci;

import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class FibonacciController {

	@GetMapping("/fibonacci/{number}")
	public String getFibonacci(@PathVariable int number) {
		for(int i = 1; i <= number; i++){
			log.info(fibonacci(i) + " ");
		}
		return "Done printing fibonacci of " + number;
	}

	@GetMapping("/sleep/{second}")
	public String sleep(@PathVariable int second) throws InterruptedException {
		Thread.sleep(second * 1000L);
		return "Slept for " + second + " seconds.";
	}

	private static int fibonacci(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibonacci(number - 1) + fibonacci(number - 2);
	}
}
