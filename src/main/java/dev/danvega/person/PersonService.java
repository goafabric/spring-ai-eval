package dev.danvega.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class PersonService implements Function<PersonService.Request, PersonService.Response> {

    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    private final List<Person> persons;

    public PersonService() {
        persons = new ArrayList<>();
        persons.add(new Person("Bart", "Simpson"));
        persons.add(new Person("Homer", "Simpson"));
        persons.add(new Person("Monty", "Burns"));
    }


    @Override
    public Response apply(Request request) {
        log.info("request {}", request);
        var person = persons.stream().filter(p -> p.firstName.equalsIgnoreCase(request.name)).toList().getFirst();
        log.info("person {}", person);
        return new Response(person);
    }

    public record Request(String name) {}
    public record Response(Person person) {}
    public record Person(String firstName, String lastName) {}
}
