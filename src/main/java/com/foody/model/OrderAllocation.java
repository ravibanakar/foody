package com.foody.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderAllocation implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long orderId;
    private Customer customer;
    private Resturant resturant;
    private DeliveryPartner deliveryPartner;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Resturant getResturant() {
        return resturant;
    }

    public void setResturant(Resturant resturant) {
        this.resturant = resturant;
    }

    public DeliveryPartner getDeliveryPartner() {
        return deliveryPartner;
    }

    public void setDeliveryPartner(DeliveryPartner deliveryPartner) {
        this.deliveryPartner = deliveryPartner;
    }
}
