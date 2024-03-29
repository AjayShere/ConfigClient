package com.ConfigClient.ConfigClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class TestController {

	@Value("${message}")
	public String message;

	@RequestMapping(value = "v1/test", method = RequestMethod.GET)
	public String testMethod() {

		System.out.println("value is " + message);
		
		return "success";
	}

}
