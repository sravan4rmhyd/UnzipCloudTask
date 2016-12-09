package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class UnZipTask {
	@Autowired
	private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(UnZipTask.class, args);
	}
	@Bean
	public UnZipCommandRunner commandRunner()
	{
		return new UnZipCommandRunner();
	}
	@Bean
	public UnZipTaskConfigurer getTaskConfigurer()
	{
		return new UnZipTaskConfigurer(dataSource);
	}
}