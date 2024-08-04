package com.ordering.system.order.service.domain.valueobject;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Data
@RequiredArgsConstructor
public class StreetAddress {

    private final UUID id;

    private final String street;

    private final String postalCode;

    private final String city;

}
