package com.foody.model;

import lombok.Data;

@Data
public class Customer {

    private Integer id;
    private String name;
    private String phone;
    private Address address;
}
