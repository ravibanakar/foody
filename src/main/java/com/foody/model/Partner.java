package com.foody.model;

import java.lang.Comparable;
import java.util.List;

public class Partner implements Comparable<Partner> {
    private Integer id;
    private String name;
    private String phone;
    private Address address;
    private Double rating;
    private List<Order> orders;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public Double getRating() {
        return rating;
    }
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int compareTo(Partner partner) {
        if(this.rating < partner.rating) return -1;
        if(this.rating > partner.rating) return 1;
        else return 0;
    }
}
