package com.resource.api.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.resource.api.entity.Pet;

@Repository
public interface IPetDao extends CrudRepository<Pet,Long>{
	
}
