package org.goafabric.springai.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PersonRepository {
    private static final Logger log = LoggerFactory.getLogger(PersonRepository.class);

    private final List<PersonRepository.Person> persons = new ArrayList<>();

    public PersonRepository() {
        persons.add(new Person("1","Bart", "Simpson"));
        persons.add(new Person("2","Homer", "Simpson"));
        persons.add(new Person("3", "Monty", "Burns"));
    }

    public Person findByFirstName(String firstName) {
        log.info("searching by firstname {}", firstName);
        return persons.stream().filter(p -> p.firstName.equalsIgnoreCase(firstName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Person with firstName '" + firstName + "' not found"));
    }

    public Person findByLastName(String lastName) {
        log.info("searching by lastname {}", lastName);
        return persons.stream().filter(p -> p.lastName.equalsIgnoreCase(lastName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Person with lastName '" + lastName + "' not found"));
    }

    public record Person(String personId, String firstName, String lastName) {}

}
