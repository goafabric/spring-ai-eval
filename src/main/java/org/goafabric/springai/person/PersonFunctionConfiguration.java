package org.goafabric.springai.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class PersonFunctionConfiguration {

    @Bean
    @Description("Get the current person by it's firstname")
    public PersonService.FindByFirstName findByFirstName() {
        return new PersonService.FindByFirstName();
    }

    @Bean
    @Description("Get the current person by it's lastname")
    public PersonService.FindByLastName findByLastName() {
        return new PersonService.FindByLastName();
    }

}
