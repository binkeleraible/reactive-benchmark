package nonreactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import nonreactive.domain.Person;
import nonreactive.repository.PersonRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getPerson() {
        return this.personRepository.findAll();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Optional<Person> getPersonById(@PathVariable("id") String id) {
        return this.personRepository.findById(id);
    }


    @RequestMapping(value = "/person/starts/{prefix}", method = RequestMethod.GET)
    public List<Person> getPersonStartsWith(@PathVariable("prefix") String prefix) {
        return this.personRepository.findByAppelationStartsWith(prefix);
    }


    @RequestMapping(
            value = "/person",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person) {
        person.setId(UUID.randomUUID().toString());
        return this.personRepository.save(person);
    }
}
