package com.example.nationalites;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Scanner;


@SpringBootApplication
@EnableScheduling
public class NationalitesApplication {
	private static final Logger log = LoggerFactory.getLogger(NationalitesApplication.class);



	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){return builder.build();}

	public void work(){
		RestTemplate restTemplate = new RestTemplate();
		Person person = restTemplate.getForObject( bringUrl(), Person.class);

		System.out.println(person.toString());
	}

	private String bringUrl(){
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		return "https://api.nationalize.io/?name=" + name ;
	}


	@Bean
	public CommandLineRunner run() throws Exception{
		return args -> work();
	}


	public static void main(String[] args) {
		SpringApplication.run(NationalitesApplication.class, args);
	}

}
