package at.spg.controller;

import at.spg.model.Encounter;
import at.spg.model.Patient;
import at.spg.repositorys.EncounterRepository;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller // This means that this class is a Controller
@RequestMapping(
    path = "/api/encounter") // This means URL's start with /api/patients(after Application path)
@CrossOrigin
public class EncounterController {

	@Autowired
	private EncounterRepository encounterRepository;
  
	@GetMapping("/{id}")
	  public ResponseEntity<Encounter> getEncounter(@PathVariable String id) {
	    return encounterRepository
	        .findById(id)
	        .map(encounter -> ResponseEntity.ok().body(encounter))
	        .orElse(ResponseEntity.notFound().build());
	  }
	@GetMapping()
	  public ResponseEntity<Iterable<Encounter>> getEncounters() {
	    return new ResponseEntity<Iterable<Encounter>>(encounterRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping()
	  public ResponseEntity<Encounter> createEncounter(@Valid @RequestBody Encounter encounter) {
	    var saved = encounterRepository.save(encounter);
	    return ResponseEntity.created(URI.create("/api/encounter/" + saved.getId())).body(saved);
	  }
	
	
	@PutMapping("/{id}")
	  public ResponseEntity<Encounter> updateEncounter(
	      @PathVariable(value = "id") String encounterId, @Valid @RequestBody Encounter encounterDetails) {
	    return encounterRepository
	        .findById(encounterId)
	        .map(
	            encounter -> {
	            	encounter.setIdentifier(encounterDetails.getIdentifier());
	            	encounter.setStatus(encounterDetails.getStatus());
	            	encounter.setStatusHistory(encounterDetails.getStatusHistory());
	            	encounter.setType(encounterDetails.getType());
	            	encounter.setSubject(encounterDetails.getSubject());
	            	encounter.setEpisodeOfCare(encounterDetails.getEpisodeOfCare());
	            	encounter.setParticipant(encounterDetails.getParticipant());
	            	encounter.setAppointment(encounterDetails.getAppointment());	            	
	            	encounter.setPeriod(encounterDetails.getPeriod());
	            	encounter.setReasonReference(encounterDetails.getReasonReference());
	            	encounter.setDiagnoses(encounterDetails.getDiagnoses());	            	
	            	encounter.setPartOf(encounterDetails.getPartOf());
	              Encounter updatedEncounter = encounterRepository.save(encounter);
	              return ResponseEntity.ok(updatedEncounter);
	            })
	        .orElse(ResponseEntity.notFound().build());
	  }
	
	// Delete an Encounter
	  @DeleteMapping("/{id}")
	  public ResponseEntity<Encounter> deleteEncounter(@PathVariable(value = "id") String encounterId) {
	    return encounterRepository
	        .findById(encounterId)
	        .map(
	            encounter -> {
	            	encounterRepository.delete(encounter);
	              return ResponseEntity.ok().<Encounter>build();
	            })
	        .orElse(ResponseEntity.notFound().build());
	  }
  
}
