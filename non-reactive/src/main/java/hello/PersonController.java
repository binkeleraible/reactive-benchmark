package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> getAllBosses2() {
        return this.personRepository.findAll();
    }

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
    public Optional<Person> getBossById2(@PathVariable("id") String id) {
        return this.personRepository.findById(id);
    }


    @RequestMapping(value = "/person/starts/{prefix}", method = RequestMethod.GET)
    public List<Person> getAllBossesStartsWith2(@PathVariable("prefix") String prefix) {
        return this.personRepository.findByLastNameStartsWith(prefix);
    }


    @RequestMapping(value = "/person", method = RequestMethod.POST)
    public @Valid Person createBoss2(@Valid @RequestBody Person person) {
        person.setId(UUID.randomUUID().toString());
        return this.personRepository.save(person);
    }
}
