package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    private ReactivePersonRepository repository;

    @RequestMapping(value = "/rperson", method = RequestMethod.GET)
    public Flux<Person> getAllBosses() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/rperson/{id}", method = RequestMethod.GET)
    public Mono<Person> getBossById(@PathVariable("id") String id) {
        return this.repository.findById(id);
    }

    @RequestMapping(value = "/rperson/starts/{prefix}", method = RequestMethod.GET)
    public Flux<Person> getAllBossesStartsWith(@PathVariable("prefix") String prefix) {
        return this.repository.findByLastNameStartsWith(prefix);
    }

    @RequestMapping(value = "/rperson", method = RequestMethod.POST)
    public Mono<@Valid Person> createBoss(@Valid @RequestBody Person person) {
        person.setId(UUID.randomUUID().toString());
        return this.repository.save(person);
    }

}
