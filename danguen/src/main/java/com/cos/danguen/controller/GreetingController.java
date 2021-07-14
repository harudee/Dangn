package com.cos.danguen.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import com.cos.danguen.model.Greeting;
import com.cos.danguen.model.HelloMessage;

@Controller
@RequestMapping("/hello")
@CrossOrigin
public class GreetingController {

	
	@GetMapping("/chat")
	public String greet() {
		return "chat";
	}
	
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(1000); // simulated delay
		return new Greeting(HtmlUtils.htmlEscape(message.getName()));
	}
}
