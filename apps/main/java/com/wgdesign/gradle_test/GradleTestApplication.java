package com.wgdesign.gradle_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = { "com.wgdesign.gradle_test", "com.wgdesign.dashboard", "com.wgdesign.shared" })
public class GradleTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(GradleTestApplication.class, args);
	}

}
