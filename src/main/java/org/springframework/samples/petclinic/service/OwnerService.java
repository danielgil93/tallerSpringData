package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.model.Owner;

public interface OwnerService {
	
	/*Taller 5*/
	Owner findById(Integer id);
    List<Owner> findByFirstNameContainsOrLastNameContains(String firstName, String lastName);
    List<Owner> findByOrderByLastNameAsc();
    
}
