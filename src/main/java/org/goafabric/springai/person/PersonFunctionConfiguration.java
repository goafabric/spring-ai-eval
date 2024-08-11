package org.goafabric.springai.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import java.util.function.Function;

@Configuration
public class PersonFunctionConfiguration {

    @Bean
    @Description("Get the current person by it's firstname")
    public Function<FirstNameRequest, PersonRepository.Person> findByFirstName(PersonRepository personRepository) {
        return request -> personRepository.findByFirstName(request.firstName());
    }

    @Bean
    @Description("Get the current person by it's lastname")
    public Function<LastNameRequest, PersonRepository.Person> findByLastName(PersonRepository personRepository) {
        return request -> personRepository.findByLastName(request.lastName());
    }

    @Bean
    @Description("Get the address of a person by it's personId")
    public Function<PersonIdRequest, AddressRepository.Address> findByPersonId(AddressRepository addressRepository) {
        return request -> addressRepository.findyByPersonId(request.personId());
    }

    public record FirstNameRequest(String firstName) {}
    public record LastNameRequest(String lastName) {}
    public record PersonIdRequest(String personId) {}


}
