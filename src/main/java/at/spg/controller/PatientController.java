package at.spg.controller;

import at.spg.model.Patient;
import at.spg.repositorys.PatientRepository;
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
    path = "/api/patient") // This means URL's start with /api/patients(after Application path)
@CrossOrigin
public class PatientController {

  @Autowired private PatientRepository patientRepository;

  // Get Patient by ID z.B. https://localhost:8080/api/patients/1213123saddfaw
  @GetMapping("/{id}")
  public ResponseEntity<Patient> getPatient(@PathVariable String id) {
    return patientRepository
        .findById(id)
        .map(patient -> ResponseEntity.ok().body(patient))
        .orElse(ResponseEntity.notFound().build());
  }

  // Get all Patients
  @GetMapping()
  public ResponseEntity<Iterable<Patient>> getPatients() {
    return new ResponseEntity<Iterable<Patient>>(patientRepository.findAll(), HttpStatus.OK);
  }

  // Create a new Patient
  @PostMapping()
  public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
    patient.getHumanname().forEach(n -> n.setId(null)); // ensure to create new names

    var saved = patientRepository.save(patient);

    return ResponseEntity.created(URI.create("/api/patient/" + saved.getId())).body(saved);
  }

  // Update a Patient
  @PutMapping("/{id}")
  public ResponseEntity<Patient> updatePatient(
      @PathVariable(value = "id") String patientId, @Valid @RequestBody Patient patientDetails) {
    return patientRepository
        .findById(patientId)
        .map(
            patient -> {
              patient.setActive(patientDetails.isActive());
              patient.setGender(patientDetails.getGender());
              patient.setIdentifier(patientDetails.getIdentifier());
              patient.setHumanname(patientDetails.getHumanname());
              patient.setAddress(patientDetails.getAddress());
              patient.setBirthDate(patientDetails.getBirthDate());
              Patient updatedPatient = patientRepository.save(patient);
              return ResponseEntity.ok(updatedPatient);
            })
        .orElse(ResponseEntity.notFound().build());
  }

  // Delete a Patient
  @DeleteMapping("/{id}")
  public ResponseEntity<Patient> deletePatient(@PathVariable(value = "id") String patientId) {
    return patientRepository
        .findById(patientId)
        .map(
            patient -> {
              patientRepository.delete(patient);
              return ResponseEntity.ok().<Patient>build();
            })
        .orElse(ResponseEntity.notFound().build());
  }
}

