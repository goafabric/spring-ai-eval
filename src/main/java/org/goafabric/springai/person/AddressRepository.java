package org.goafabric.springai.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
public class AddressRepository {

    private static final Logger log = LoggerFactory.getLogger(AddressRepository.class);
    private final List<Address> addresses= new ArrayList<>();

    public AddressRepository() {
        addresses.add(new Address("1", "Evergreen Terrace 753", "Springfield"));
        addresses.add(new Address("2", "EverblueTerrace 753", "Springfield"));
        addresses.add(new Address("3", "Croesus Street", "Shelbyville"));
    }

    public Address findyByPersonId(String personId) {
        return addresses.stream()
                .filter(address -> address.personId.equals(personId))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Address with personId '" + personId + "' not found"));

    }
    public record Address(String personId, String street, String city){}

}
