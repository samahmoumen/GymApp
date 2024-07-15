package com.example.memberclass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MemberClassApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberClassApplication.class, args);
	}

}
