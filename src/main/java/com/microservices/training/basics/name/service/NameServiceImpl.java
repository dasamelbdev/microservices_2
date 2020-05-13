package com.microservices.training.basics.name.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.microservices.training.basics.name.model.NameDTO;

@Service
public class NameServiceImpl implements NameService {

	@Value("${name}")
	private String name;

	@Override
	public NameDTO sendName() {
		// TODO Auto-generated method stub
		NameDTO nameDTO = new NameDTO();
		nameDTO.setName(this.name);
		return nameDTO;
	}
	
	
	
	
}
