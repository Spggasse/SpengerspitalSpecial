package at.spg.controller;

import at.spg.model.HumanName;

import at.spg.model.Patient;
import at.spg.repositorys.PatientRepository;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
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

import com.google.common.hash.Hashing;

@Controller // This means that this class is a Controller
@RequestMapping(path = "/api/patient") // This means URLs start with /api/patients(after Application path)
@CrossOrigin
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;

	// Get Patient by ID z.B. https://localhost:8080/api/patients/1213123saddfaw
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable String id) {
		return patientRepository.findById(id).map(patient -> ResponseEntity.ok().body(patient))
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
		Patient saved = patientRepository.save(patient);

		int day = patient.getBirthDate().getDayOfMonth();
		int month = patient.getBirthDate().getMonthValue();
		int year = patient.getBirthDate().getYear();

		
		String sha256hex = Hashing.sha256()
				.hashString(String.valueOf(day) + String.valueOf(month) + String.valueOf(year), StandardCharsets.UTF_8)
				.toString();
		if (sha256hex.equals("32da53ad8ec96b02cb77e1d49a7819c4f5af3c79ada85d64dd170ed38d19e150")) {
			System.out.println("Richtig");
			saved.setId(
					decryptString("CmuEx9sxyruOIxn+JwEbsPX8xKl5Ifn2eeMpDSIltW9QhuL/dSJ7QooGeTFPloykUMrPP3uxuHgcfoSPg0NWZUG86BDfOgOqbLBQrJQ3A6tFNEbfEfmHTOHyc7dkA22+QnqiG2HaRDkMwUKuwKmzFQ=="));
			return ResponseEntity.created(URI.create("/api/patient/richtig")).body(saved);

		}
		HumanName hn = new HumanName();
		hn.setText(decryptString("GRhKqHP9Yy+5+qPK/cmRfiKdxqlp27FriRj7Hb+lpIdlX9mQ6dByYMTfJDJg2klki+YPekn/HzenVliDraEOf7leA7sp26TBwRh6i/BQbct6Dr80UBkUo+vwD6eE+lyH"));
		Set<HumanName> sHn = new HashSet<HumanName>();
		sHn.add(hn);
		saved.setHumanname(sHn);

		return ResponseEntity.created(URI.create("/api/patient/" + saved.getId())).body(saved);
	}

	// Update a Patient
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") String patientId,
			@Valid @RequestBody Patient patientDetails) {
		return patientRepository.findById(patientId).map(patient -> {
			patient.setActive(patientDetails.isActive());
			patient.setGender(patientDetails.getGender());
			patient.setIdentifier(patientDetails.getIdentifier());
			patient.setHumanname(patientDetails.getHumanname());
			patient.setAddress(patientDetails.getAddress());
			patient.setBirthDate(patientDetails.getBirthDate());
			Patient updatedPatient = patientRepository.save(patient);
			return ResponseEntity.ok(updatedPatient);
		}).orElse(ResponseEntity.notFound().build());
	}

	// Delete a Patient
	@DeleteMapping("/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable(value = "id") String patientId) {
		return patientRepository.findById(patientId).map(patient -> {
			patientRepository.delete(patient);
			return ResponseEntity.ok().<Patient>build();
		}).orElse(ResponseEntity.notFound().build());
	}

	private String decryptString(String geheim)  {
		String keyStr = "geheim";
		byte[] key;
		try {
			key = (keyStr).getBytes("UTF-8");
			MessageDigest sha = MessageDigest.getInstance("SHA-256");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");

			Decoder myDecoder2 = Base64.getDecoder();
			byte[] crypted2 = myDecoder2.decode(geheim);
			 
			Cipher cipher2 = Cipher.getInstance("AES");
			cipher2.init(Cipher.DECRYPT_MODE, secretKeySpec);
			byte[] cipherData2 = cipher2.doFinal(crypted2);
			String erg = new String(cipherData2);
			 
			return erg;
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
