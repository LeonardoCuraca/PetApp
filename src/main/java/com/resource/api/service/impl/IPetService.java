package com.resource.api.service.impl;

import java.util.List;

import com.resource.api.entity.Pet;

public interface IPetService {
	
	public List<Pet>findAll();
	
	public void savePet(Pet pet);
	
	public Pet findById(Long petid);
	
}
