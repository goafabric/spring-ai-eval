package org.goafabric.springai.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class AddressService {

    private static final Logger log = LoggerFactory.getLogger(AddressService.class);

    private static final List<Address> addresses= new ArrayList<>();

    static {
        addresses.add(new Address("1", "Evergreen Terrace 753", "Springfield"));
        addresses.add(new Address("2", "EverblueTerrace 753", "Springfield"));
        addresses.add(new Address("3", "Croesus Street", "Shelbyville"));
    }

    static class FindByPersonId implements Function<PersonIdRequest, Address> {
        @Override
        public Address apply(PersonIdRequest request) {
            log.info("searching address by personid {}", request);
            return addresses.stream()
                    .filter(address -> address.personId.equals(request.personId))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Address with personId '" + request.personId + "' not found"));
        }
    }

    public record PersonIdRequest(String personId) {}
    public record Address(String personId, String street, String city){}

}
