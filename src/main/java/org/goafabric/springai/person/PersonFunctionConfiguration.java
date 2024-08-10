package org.goafabric.springai.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class PersonFunctionConfiguration {

    @Bean
    @Description("Get the current person by it's firstname")
    public PersonService findByFirstName() {
        return new PersonService();
    }

    @Bean
    @Description("Get the current person by it's lastname")
    public PersonServiceLastName findByLastName() {
        return new PersonServiceLastName();
    }

}
