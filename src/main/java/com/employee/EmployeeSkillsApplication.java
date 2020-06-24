package com.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.employee")
@EnableJpaRepositories("com.employee.repository")
@EntityScan("com.employee.model")
@EnableJpaAuditing
public class EmployeeSkillsApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EmployeeSkillsApplication.class, args);
	}
}
