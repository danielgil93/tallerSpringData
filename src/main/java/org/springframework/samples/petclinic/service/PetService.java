package org.springframework.samples.petclinic.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {
	
	@Autowired
	PetRepository repositorio;

	public List<Pet> findByBirthDateBetweenOrderByBirthDateAsc (Date d1, Date d2){
		return repositorio.findByBirthDateBetweenOrderByBirthDateAsc(d1, d2);
	}
	
	
	
}
