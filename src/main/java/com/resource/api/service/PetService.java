package com.resource.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.resource.api.dao.IPetDao;
import com.resource.api.entity.Pet;
import com.resource.api.service.impl.IPetService;


@Service
public class PetService implements IPetService{
	
	@Autowired
	private IPetDao petDao;
	
	@Transactional(readOnly=true)
	public List<Pet>findAll() {
		return (List<Pet>) petDao.findAll();
	}

	@Override
	public void savePet(Pet pet) {
		petDao.save(pet);
	}

	@Override
	public Pet findById(Long petid) {
		return petDao.findById(petid).orElse(null);
	}



}
