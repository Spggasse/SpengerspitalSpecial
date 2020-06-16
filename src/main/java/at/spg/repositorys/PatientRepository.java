package at.spg.repositorys;

import org.springframework.data.repository.PagingAndSortingRepository;
//das repository greift auf die db zu 

import at.spg.model.Patient;

public interface PatientRepository extends PagingAndSortingRepository <Patient,String>{
	
	
	

}
