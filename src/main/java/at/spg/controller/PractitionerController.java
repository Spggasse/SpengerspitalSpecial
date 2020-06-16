package at.spg.controller;


import at.spg.model.Practitioner;
import at.spg.repositorys.EncounterRepository;
import at.spg.repositorys.PractitionerRepository;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller // This means that this class is a Controller
@RequestMapping(
    path = "/api/practitioner") // This means URL's start with /api/practitioner(after Application path)
@CrossOrigin
public class PractitionerController {

	@Autowired
	private PractitionerRepository practitionerRepository;
  
	@GetMapping("/{id}")
	  public ResponseEntity<Practitioner> getPractitioner(@PathVariable String id) {
	    return practitionerRepository
	        .findById(id)
	        .map(practitioner -> ResponseEntity.ok().body(practitioner))
	        .orElse(ResponseEntity.notFound().build());
	  }
	@GetMapping()
	  public ResponseEntity<Iterable<Practitioner>> getPractitioners() {
	    return new ResponseEntity<Iterable<Practitioner>>(practitionerRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping()
	  public ResponseEntity<Practitioner> createPractitioner(@Valid @RequestBody Practitioner practitioner) {
	    var saved = practitionerRepository.save(practitioner);
	    return ResponseEntity.created(URI.create("/api/practitioner/" + saved.getId())).body(saved);
	  }
	
	
	@PutMapping("/{id}")
	  public ResponseEntity<Practitioner> updatePractitioner(
	      @PathVariable(value = "id") String practitionerId, @Valid @RequestBody Practitioner practitionerDetails) {
	    return practitionerRepository
	        .findById(practitionerId)
	        .map(
	        	practitioner -> {
	        		practitioner.setIdentifier(practitionerDetails.getIdentifier());
	        		practitioner.setActive(practitionerDetails.isActive());
	        		practitioner.setHumanname(practitionerDetails.getHumanname());
	        		practitioner.setContactpoint(practitionerDetails.getContactpoint());
	        		practitioner.setGender(practitionerDetails.getGender());
	        		practitioner.setBirthDate(practitionerDetails.getBirthDate());
	        		practitioner.setAttachment(practitionerDetails.getAttachment());
	        		practitioner.setQualification(practitionerDetails.getQualification());	            	
	        		practitioner.setCommunication(practitionerDetails.getCommunication());
	        		practitioner.setPeriod(practitionerDetails.getPeriod());
	            	Practitioner updatedPractitioner = practitionerRepository.save(practitioner);
	              return ResponseEntity.ok(updatedPractitioner);
	            })
	        .orElse(ResponseEntity.notFound().build());
	  }
	
	// Delete an Practitioner
	  @DeleteMapping("/{id}")
	  public ResponseEntity<Practitioner> deletePractitioner(@PathVariable(value = "id") String practitionerId) {
	    return practitionerRepository
	        .findById(practitionerId)
	        .map(
	        		practitioner -> {
	        			practitionerRepository.delete(practitioner);
	              return ResponseEntity.ok().<Practitioner>build();
	            })
	        .orElse(ResponseEntity.notFound().build());
	  }
  
}
