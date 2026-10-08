package com.tomato.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class Address {

    @JoinColumn(name = "users")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String street;
    private String city;
    private String state;
    private String zipcode;
}
