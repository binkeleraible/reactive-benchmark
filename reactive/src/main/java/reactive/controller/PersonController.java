package reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactive.domain.Person;
import reactive.repository.ReactivePersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    @Autowired
    private ReactivePersonRepository repository;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public Flux<Person> getPerson() {
        return this.repository.findAll();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Mono<Person> getPersonById(@PathVariable("id") String id) {
        return this.repository.findById(id);
    }

    @RequestMapping(value = "/person/starts/{prefix}", method = RequestMethod.GET)
    public Flux<Person> getPersonStartsWith(@PathVariable("prefix") String prefix) {
        return this.repository.findByAppelationStartsWith(prefix);
    }

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public Mono<Person> createPerson(@RequestBody Person person) {
        //person.setId(UUID.randomUUID().toString());
        return this.repository.save(person);
    }

}
