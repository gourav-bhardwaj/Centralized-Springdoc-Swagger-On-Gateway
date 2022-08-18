package com.sp.departmentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/department")
	public ResponseEntity<String> departmentDummy() {
		return ResponseEntity.ok("Department microservice!!");
	}
	
	@GetMapping("/department/port")
	public ResponseEntity<String> departmentPort() {
		return ResponseEntity.ok("Department service port: %d".formatted(port));
	}

}
