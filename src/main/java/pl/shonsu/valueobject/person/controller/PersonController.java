package pl.shonsu.valueobject.person.controller;

import org.springframework.web.bind.annotation.*;
import pl.shonsu.valueobject.person.model.Address;
import pl.shonsu.valueobject.person.model.Email;
import pl.shonsu.valueobject.person.model.NaturalPersonName;
import pl.shonsu.valueobject.person.model.Person;
import pl.shonsu.valueobject.person.repository.PersonRepository;

@RequestMapping("/person")
@RestController
class PersonController {
    private final PersonRepository personRepository;

    PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    Person getPerson(@RequestParam Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @GetMapping("/searchByEmail/{email}")
    Person getPersonByEmail(@PathVariable Email email) {
        return personRepository.findByEmail(email).orElseThrow();
    }

    @GetMapping("/searchByAddress")
    Person getPersonByAddress(@RequestBody Address address) {
        return personRepository.findByAddress(address).orElseThrow();
    }

    @GetMapping("/searchByNaturalPersonName")
    Person getPersonByNaturalPersonName(@RequestBody NaturalPersonName personName) {
        return personRepository.findByNaturalPersonName(personName).orElseThrow();
    }

}
