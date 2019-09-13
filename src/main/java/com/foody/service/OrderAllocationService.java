package com.foody.service;

import com.foody.model.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class OrderAllocationService {

    /**
     *
     * @param pickupAddress
     * @return
     */
    public List<DeliveryPartner> getDeliverPartners(Address pickupAddress) {

        //Login to get All delivery partners surrounding pickup address (may be 2 KM radius)

        List<DeliveryPartner> deliveryPartners = new ArrayList<>();
        DeliveryPartner deliveryPartner = new DeliveryPartner();
        deliveryPartner.setId(1234);
        deliveryPartner.setPhone("12345667");
        Address address = new Address();
        address.setId(1234L);
        address.setLangitude(12.34);
        address.setLatitude(31.42);
        deliveryPartner.setAddress(address);
        deliveryPartners.add(deliveryPartner);
        return deliveryPartners;
    }

    /**
     *
     * @param orderId
     * @param resturant
     * @param customer
     * @return
     */
    public OrderAllocation allocateOrder(Long orderId, Resturant resturant, Customer customer) {

        List<DeliveryPartner> deliveryPartners = getDeliverPartners(resturant.getAddress());

        Map<Double, List<DeliveryPartner>> partnerStringMap = new TreeMap<>();
        for (DeliveryPartner partner : deliveryPartners) {
            Double distance = getDistance(resturant.getAddress(), partner.getAddress(), "K");
            if(partnerStringMap.containsKey(distance)) {
                List<DeliveryPartner> partnerList = partnerStringMap.get(distance);
                partnerList.add(partner);
                partnerStringMap.put(distance, partnerList);
            } else {
                List<DeliveryPartner> partners = new ArrayList<>();
                partners.add(partner);
                partnerStringMap.put(distance, partners);
            }
        }
        DeliveryPartner deliveryPartner = partnerStringMap.get(0).get(0);
        OrderAllocation orderAllocation = new OrderAllocation();
        orderAllocation.setOrderId(orderId);
        orderAllocation.setDeliveryPartner(deliveryPartner);
        orderAllocation.setCustomer(customer);
        orderAllocation.setResturant(resturant);

        return orderAllocation;
    }

    public Double getDistance(Address l1, Address l2, String unit) {
        Double lon1 = l1.getLangitude();
        Double lon2 = l2.getLangitude();
        Double lat1 = l1.getLatitude();
        Double lat2 = l2.getLatitude();
        if ((lon1.equals(lon2)) && (lat1.equals(lat2))) {
            return 0.0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) +
                    Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if ("K".equals(unit)) {
                dist = dist * 1.609344;
            } else if ("N".equals(unit)) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

}
