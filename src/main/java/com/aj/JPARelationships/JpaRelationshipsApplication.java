package com.aj.JPARelationships;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JpaRelationshipsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipsApplication.class, args);
	}

	@RequestMapping("/")
	public @ResponseBody Object home(){
		return "hello";
	}

}
