package at.spg;


import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import at.spg.model.Address;
import at.spg.model.Address.UseType;

import at.spg.model.Attachment;
import at.spg.model.CodeableConcept;
import at.spg.model.Identifier;
import at.spg.model.Identifier.UseCode;
import at.spg.model.Patient;
import at.spg.model.Patient.GenderCode;
import at.spg.model.Period;
import at.spg.repositorys.PatientRepository;
import at.spg.model.Coding;
import at.spg.model.ContactPoint;
import at.spg.model.ContactPoint.UseContactPoint;
import at.spg.model.HumanName;
import at.spg.model.HumanName.NameUseCode;

@SpringBootTest
public class PatientRepositoryTest {
	
	@Autowired
	PatientRepository patientrepository;
	
	@Test
	void testSaveOnePatient() {

		Set<Identifier> identifier = new HashSet<Identifier>();
		Period period = new Period(LocalDateTime.of(2000,01,01,1,1), LocalDateTime.of(2010,01,01,1,1) );
		Set<Coding> coding = new HashSet<Coding>();
		coding.add(new Coding("Version", "Something", "Nochmal", "WTH", true));
		CodeableConcept ccType = new CodeableConcept(coding, "Text");
		identifier.add(new Identifier(UseCode.official, ccType, "System", "Value", period));
		
		
		
		
		Set<ContactPoint> contactpoints = new HashSet<ContactPoint>();
		contactpoints.add(new ContactPoint(UseContactPoint.phone, "Text", at.spg.model.ContactPoint.UseCode.home, period, "rank"));
		Set<HumanName> names = new HashSet<HumanName>();
		names.add(new HumanName(NameUseCode.usual,"Jim", "Parker", "", "", "", period));
		
		Set<Address> address = new HashSet<Address>();
		
		address.add(new Address(at.spg.model.Address.UseCode.home, UseType.both, "text", "Line", "Wien", "Favoriten", "Wien", "1050", "Oesterreich", period));
		Set<Attachment> attachment = new HashSet<Attachment>();
		Patient p = new Patient(true, GenderCode.female, LocalDate.of(2000, 01, 01), false, identifier, names, contactpoints, address, attachment);
		// Patienteninstanz erstellen
		
		// testdaten befüllen
		
		//insnatn speichern
		System.out.println("Hier beginnt der Test!!! Also gut aufpassen:)");
		System.out.println("Shutting down.");
		System.out.println("Shutting down..");
		System.out.println("Shutting down...");
		Patient savedP = patientrepository.save(p);
		//Lesen 
		System.out.println("TEST2");
		
		Patient loadedPatient = patientrepository.findById(savedP.getId()).get();
		//vergleich der gespeicherten daten mit dem Geladenen
		
		assertTrue(p.isActive()== loadedPatient.isActive());
		assertNotNull(loadedPatient.getId());
		assertTrue(CollectionUtils.isEqualCollection(p.getHumanname(), loadedPatient.getHumanname()));
		
	}

}
