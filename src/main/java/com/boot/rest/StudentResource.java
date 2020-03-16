package com.boot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentResource {

	@Autowired
	StudentRepository sRepo;

	@GetMapping("student")
	public List<Student> getStudent() {
		System.out.println("ok");
		List<Student> sList = (List<Student>) sRepo.findAll();
		return sList;
	}

	@PostMapping("student")
	public Student createStudent(@RequestBody Student s) {
		System.out.println("Creating student... : "+s.getsId());
		sRepo.save(s);
		return s;
	}

}
