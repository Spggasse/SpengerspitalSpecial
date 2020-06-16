package at.spg.repositorys;

import org.springframework.data.repository.PagingAndSortingRepository;
import at.spg.model.Practitioner;

public interface PractitionerRepository  extends PagingAndSortingRepository <Practitioner,String> {

}
