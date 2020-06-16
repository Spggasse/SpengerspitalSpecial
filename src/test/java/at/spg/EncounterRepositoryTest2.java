package at.spg;

import at.spg.model.*;
import at.spg.repositorys.EncounterRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.jupiter.api.Assertions.*;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@SpringBootTest
public class EncounterRepositoryTest2 {
    @Autowired
    EncounterRepository encounterRepository;
	
	@Transactional
    @Test
    public void TestSaveOneEncounter(){
		
		//Aus unbekannten Gründen Funktioniert das nicht so wirklich
        Set<Identifier> identifiers = new HashSet<>();
        Set<Coding> codings = new HashSet<>();
        Set<CodeableConcept> cc = new HashSet<>();

        Period period = new Period(LocalDateTime.of(2001, 11,21,1,1), LocalDateTime.of(2005,02,05,1,1));
        codings.add(new Coding("Now", "1", "UseCode", "1232", true));
		CodeableConcept ccType = new CodeableConcept(codings, "Stuff");
        
        cc.add(new CodeableConcept(codings, "test"));

        identifiers.add(new Identifier(Identifier.UseCode.official,ccType, "Then", "423", period));
        
        Encounter enc2 = new Encounter(identifiers);
        Encounter savedEnc = encounterRepository.save(enc2);
        Encounter loadedEnc = encounterRepository.findById(enc2.getId()).get();


        assertTrue(CollectionUtils.isEqualCollection(savedEnc.getIdentifier(), loadedEnc.getIdentifier()));
        assertEquals(savedEnc, loadedEnc);

    }
}
