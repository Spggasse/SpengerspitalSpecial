package at.spg.repositorys;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;


import at.spg.model.Greetings;

import java.util.List;

public interface GreetingRepository extends PagingAndSortingRepository <Greetings, Long> {

	List <Greetings> findById(@Param("id") String id);
	
	List <Greetings> findByContent(@Param("content") String content);
	

	}

