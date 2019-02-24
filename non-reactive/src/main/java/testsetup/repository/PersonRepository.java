
package testsetup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import testsetup.domain.Person;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

	List<Person> findByAppelationStartsWith(String name);

}
