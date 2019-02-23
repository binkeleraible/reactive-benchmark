package hello;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ReactivePersonRepository extends ReactiveMongoRepository<Person, String> {
    Flux<Person> findByLastNameStartsWith(@Param("name") String name);
}
