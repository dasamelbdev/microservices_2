package com.microservices.training.basics.name.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.microservices.training.basics.name.model.NameDTO;
import com.microservices.training.basics.name.service.NameService;

@RestController
@RequestMapping("/api")
public class NameController {

	@Autowired
	private NameService nameService;

	@GetMapping("/name")
	public ResponseEntity<NameDTO> sendGreeting() {

		NameDTO name = nameService.sendName();
		if (name == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<NameDTO>(name, HttpStatus.OK);

	}

}
