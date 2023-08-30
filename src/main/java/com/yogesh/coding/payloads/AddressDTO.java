package com.yogesh.coding.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {

    private Long id;
    private String streetAddress;
    private String city;
    private String postalCode;
    private String state;
    private String country;

    // Other fields, constructors, getters, setters, etc.
}
