package dev.danvega.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

@Configuration
public class PersonFunctionConfiguration {

    @Bean
    @Description("Get the current person by it's name")
    public PersonService personFunction() {
        return new PersonService();
    }

}
