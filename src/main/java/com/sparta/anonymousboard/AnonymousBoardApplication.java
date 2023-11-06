package com.sparta.anonymousboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.sparta.anonymousBoard.example.board.entity")
public class AnonymousBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnonymousBoardApplication.class, args);
	}

}
