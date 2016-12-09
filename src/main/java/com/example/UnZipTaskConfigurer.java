package com.example;

import javax.sql.DataSource;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;

public class UnZipTaskConfigurer extends DefaultTaskConfigurer{
	
	public UnZipTaskConfigurer(DataSource dataSource) {
		super(dataSource);
	}
	
}