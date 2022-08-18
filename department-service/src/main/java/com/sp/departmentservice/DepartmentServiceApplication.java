package com.sp.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
		info = @Info(contact = @Contact(name = "gourav kumar", 
email = "gov.kumarbharatdwaj@gmail.com"), title = "Department Service", 
termsOfService = "www.department.com/terms-and-condition", 
description = "Department service provide the department informations to the other users.", 
license = @License(name = "department service licence", url = "www.department.com/licence"),
version = "v1"))
@SpringBootApplication
public class DepartmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
