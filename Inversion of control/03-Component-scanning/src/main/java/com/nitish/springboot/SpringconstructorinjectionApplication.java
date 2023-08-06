package com.nitish.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {"com.nitish.util",
		                     "com.nitish.springboot" }
)
public class SpringconstructorinjectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringconstructorinjectionApplication.class, args);
	}

}
