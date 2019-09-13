package com.foody.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;
    private Timestamp orderedTime;
    private Timestamp shippedTime;
    private int status;
    private Customer customer;
    private Partner partner;
    private Resturant resturant;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getOrderedTime() {
        return orderedTime;
    }

    public void setOrderedTime(Timestamp orderedTime) {
        this.orderedTime = orderedTime;
    }

    public Timestamp getShippedTime() {
        return shippedTime;
    }

    public void setShippedTime(Timestamp shippedTime) {
        this.shippedTime = shippedTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }
}
