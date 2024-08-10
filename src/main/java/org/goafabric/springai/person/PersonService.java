package org.goafabric.springai.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class PersonService implements Function<PersonService.FirstNameRequest, PersonService.Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final List<Person> persons;

    public PersonService() {
        persons = new ArrayList<>();
        persons.add(new Person("0","Bart", "Simpson"));
        persons.add(new Person("1","Homer", "Simpson"));
        persons.add(new Person("2", "Monty", "Burns"));
    }


    @Override
    public Person apply(FirstNameRequest request) {
        log.info("searching by firstname {}", request);
        var person = persons.stream().filter(p -> p.firstName.equalsIgnoreCase(request.firstName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Person with firstName '" + request.firstName + "' not found"));
        log.info("person {}", person);
        return person;
    }

    public record FirstNameRequest(String firstName) {}
    public record Person(String id, String firstName, String lastName) {}
}
