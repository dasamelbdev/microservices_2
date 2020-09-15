package com.microservices.training.basics.name.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

	private static final Logger logger = LoggerFactory.getLogger(NameController.class);

	@Autowired
	private Environment env;

	@Autowired
	private NameService nameService;

	@GetMapping("/name")
	public ResponseEntity<NameDTO> sendGreeting() {

		/*
		 * command line args will be added to the spring Environment bean. Also we can
		 * access OS level environment variables through spring Environment bean.
		 * 
		 */
		logger.info("JAVA_HOME :" + env.getProperty("JAVA_HOME"));
		logger.info(env.getProperty("spring.application.name") + " instance with port :"
				+ env.getProperty("server.port") + " called");

		NameDTO name = nameService.sendName();
		if (name == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else
			return new ResponseEntity<NameDTO>(name, HttpStatus.OK);

	}

}
