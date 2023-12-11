package com.ldd;

import com.ldd.analyzer.MyStackException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootFailApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(SpringBootFailApplication.class);
		springApplication.run(args);



	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return (args) -> {
			throw new MyStackException("我的栈异常");
		};
	}

}
