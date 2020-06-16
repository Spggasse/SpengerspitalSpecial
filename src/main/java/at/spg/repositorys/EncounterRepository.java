package at.spg.repositorys;

import org.springframework.data.repository.PagingAndSortingRepository;
//das repository greift auf die db zu 

import at.spg.model.Encounter;


public interface EncounterRepository extends PagingAndSortingRepository <Encounter,String>{
	
	
	

}
