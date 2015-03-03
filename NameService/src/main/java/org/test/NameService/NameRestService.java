package org.test.NameService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NameRestService {
	
	@RequestMapping("/firstName")
	public String getFirstName() {
		return "John";
	}
	
	@RequestMapping("/lastName")
	public String getLastName() {
		return "Smith";
	}
}
