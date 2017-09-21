package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

@Service
public class OwnerServiceImpl implements OwnerService {
	
	/*Taller 5*/
	@Autowired
	OwnerRepository repositorio;

	@Override
	public Owner findById(Integer id) {
		return repositorio.findById(id);
	}

	@Override
	public List<Owner> findByFirstNameContainsOrLastNameContains(String firstName, String lastName) {
		return repositorio.findByFirstNameContainsOrLastNameContains(firstName, lastName);
	}

	@Override
	public List<Owner> findByOrderByLastNameAsc() {
		return repositorio.findByOrderByLastNameAsc();
	}
	
}
