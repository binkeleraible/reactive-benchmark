package reactive.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactive.domain.Person;
import reactor.core.publisher.Flux;

@Repository
public interface ReactivePersonRepository extends ReactiveMongoRepository<Person, String> {
    Flux<Person> findByAppelationStartsWith(String name);
}
