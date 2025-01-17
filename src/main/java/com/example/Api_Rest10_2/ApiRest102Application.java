package com.example.Api_Rest10_2;

import com.example.Api_Rest10_2.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApiRest102Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ApiRest102Application.class, args);
                UserRepository repository = context.getBean(UserRepository.class);
                System.out.println(repository.count());
	}

}
