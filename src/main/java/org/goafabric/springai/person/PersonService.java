package org.goafabric.springai.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private static final List<PersonService.Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("1","Bart", "Simpson"));
        persons.add(new Person("2","Homer", "Simpson"));
        persons.add(new Person("3", "Monty", "Burns"));
    }

    static class FindByFirstName implements Function<FirstNameRequest, Person> {
        @Override
        public Person apply(FirstNameRequest request) {
            log.info("searching by firstname {}", request);
            return persons.stream().filter(p -> p.firstName.equalsIgnoreCase(request.firstName))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Person with firstName '" + request.firstName + "' not found"));
        }
    }

    static class FindByLastName implements Function<LastNameRequest, Person> {
        @Override
        public Person apply(LastNameRequest request) {
            log.info("searching by lastname {}", request);
            return persons.stream().filter(p -> p.lastName.equalsIgnoreCase(request.lastName))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Person with lastName '" + request.lastName + "' not found"));
        }
    }

    public record FirstNameRequest(String firstName) {}
    public record LastNameRequest(String lastName) {}

    public record Person(String personId, String firstName, String lastName) {}

}
