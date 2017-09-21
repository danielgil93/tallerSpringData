/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.SpecialityRepository;
import org.springframework.samples.petclinic.repository.VetRepository;

import antlr.collections.List;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {
	
	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PetClinicApplication.class, args);
    }
    
    @Bean
	public CommandLineRunner demoVetRepository(VetRepository vetRepository, SpecialityRepository specialityRepository) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			log.info("*****************************************************");
			
			//TODO Añade aquí tu código
			
			/*Taller 1*/
			log.info("Creamos objeto Vet");
			Vet vet1 = new Vet();
			Vet vetalm = new Vet();
			vet1.setFirstName("Daniel");
			vet1.setLastName("Gil");
			
			log.info("Guardamos en la BBDD");
			vet1 = vetRepository.save(vet1);
			
			log.info("Comprobamos que se ha guardado correctamente");
			vetalm = vetRepository.findOne(vet1.getId());
			log.info(vet1.toString());
			
			log.info("Añadimos speciality");
			vet1.addSpecialty(specialityRepository.findOne(1));
			vet1 = vetRepository.save(vet1);
			
			log.info("Comprobamos que se ha guardado correctamente la speciality");
			log.info(vet1.toString());
			
			log.info("Listamos los veterinarios");
			for(Vet v: vetRepository.findAll()){
		    	log.info("Vet: "+v);
		    }
			
			/*Taller 2*/
			log.info("Filtramos por lastName=Gil");
		    for(Vet v: vetRepository.findByLastName("Gil")){
		    	log.info("Vet: "+v);
		    }
		    
		    log.info("Filtramos por lastName=Gil y firstName=Daniel");
		    for(Vet v: vetRepository.findByFirstNameAndLastName("Daniel", "Gil")){
		    	log.info("Vet: "+v);
		    }
		    
		    log.info("Filtramos por firstName o lastname");
		    for(Vet v: vetRepository.findByFirstNameOrLastName("Daniel", "Daniel")){
		    	log.info("Vet: "+v);
		    }
		    
		    /*Taller 3*/
		    log.info("Filtramos por especialidad");
		    for(Vet v: vetRepository.findBySpecialityName("radiology")){
		    	log.info("Vet: "+v);
		    }
		    
		};
	}
    
    @Bean
	public CommandLineRunner demoOwnerRepository(OwnerRepository ownerRepository) {
		return (args) -> {
			log.info("*****************************************************");
		    log.info("BOOTCAMP - Spring y Spring Data - OwnerRepository");
		    log.info("*****************************************************");
		    
		    /*Taller 4*/
		    log.info("Filtramos por nombre o apellido contains");
		    for(Owner o: ownerRepository.findByFirstNameContainsOrLastNameContains("t", "x")){
		    	log.info("Owner: "+o);
		    }
		    
		    log.info("Filtramos por apellido ordenado");
		    for(Owner o: ownerRepository.findByOrderByLastNameAsc()){ 
		    	log.info("Owner: "+o);
		    }
		   
		};
    }
    
}
