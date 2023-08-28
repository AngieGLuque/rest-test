package com.backtest.restservice;

import javax.swing.JOptionPane;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RestServiceApplication.class, args);
		
		//int exitcode = SpringApplication.exit(ctx, () -> 0);
		//System.exit(exitcode);
	}

}
