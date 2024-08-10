package org.goafabric.springai.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class PersonServiceLastName implements Function<PersonServiceLastName.Request, PersonServiceLastName.Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonServiceLastName.class);

    private final List<Person> persons;

    public PersonServiceLastName() {
        persons = new ArrayList<>();
        persons.add(new Person("0","Bart", "Simpson"));
        persons.add(new Person("1","Homer", "Simpson"));
        persons.add(new Person("2", "Monty", "Burns"));
    }


    @Override
    public Person apply(Request request) {
        log.info("searching by lastname {}", request);
        var person = persons.stream().filter(p -> p.lastName.equalsIgnoreCase(request.lastName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Person with lastName '" + request.lastName + "' not found"));
        log.info("person {}", person);
        return person;
    }

    public record Request(String lastName) {}
    public record Person(String id, String firstName, String lastName) {}
}
