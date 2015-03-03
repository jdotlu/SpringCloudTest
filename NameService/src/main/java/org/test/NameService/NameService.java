package org.test.NameService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class NameService {
	
	@RequestMapping("/")
	public String getName() {
		return "John Smith";
	}
}
