package com.boot.rest;

import java.net.URI;
import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class StudentResource {

	@Autowired
	StudentRepository sRepo;

	@GetMapping("student")
	public List<Student> getStudent() {
		System.out.println("ok.. Delivering.....");
		System.out.println("adding logs...");
		List<Student> sList = (List<Student>) sRepo.findAll();
		return sList;
	}
	
	@GetMapping("student/{id}")
	public Student getStudent(@PathVariable int id) {
		System.out.println("ok.. Delivering.....");
		System.out.println("adding logs...");
		Optional<Student> sList = sRepo.findById(id);
		if(!sList.isPresent()) {
			throw new StudentNotFoundException("Student not found!");
		}
		
		return sList.get();
	}

	@PostMapping("student")
	public ResponseEntity<Object> createStudent(@Valid @RequestBody Student s) {
		System.out.println("Creating student... : "+s.getsId());
		sRepo.save(s);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(s.getsId()).toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Object> deleteStudent(@PathVariable int id){
		System.out.println("Deleting Student... : "+id);
		Optional<Student> sList = sRepo.findById(id);
		if(!sList.isPresent()) {
			throw new StudentNotFoundException("Student not found!");
		}
		sRepo.deleteById(id);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		System.out.println(location);
		return ResponseEntity.created(location).build();
	}

}
