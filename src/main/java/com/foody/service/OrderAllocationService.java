package com.foody.service;

import com.foody.model.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderAllocationService {

    /**
     *
     * @param pickupAddress
     * @return
     */
    public List<Partner> getDeliverPartners(Address pickupAddress) {

        //Login to get All delivery partners surrounding pickup address (may be 2 KM radius)

        List<Partner> partners = new ArrayList<>();
        Partner partner = new Partner();
        partner.setId(1234);
        partner.setPhone("12345667");
        Address address = new Address();
        address.setId(1234L);
        address.setLangitude(12.34);
        address.setLatitude(31.42);
        partner.setAddress(address);
        partners.add(partner);
        return partners;
    }

    /**
     *
     * @param orderId
     * @param resturant
     * @param customer
     * @return
     */
    public Order allocateOrder(Integer orderId, Resturant resturant, Customer customer) {

        List<Partner> deliveryPartners = getDeliverPartners(resturant.getAddress());

        Map<Double, List<Partner>> partnerStringMap = new TreeMap<>();
        for (Partner partner : deliveryPartners) {
            Double distance = getDistance(resturant.getAddress(), partner.getAddress());
            if(partnerStringMap.containsKey(distance)) {
                List<Partner> partnerList = partnerStringMap.get(distance);
                partnerList.add(partner);
                partnerStringMap.put(distance, partnerList);
            } else {
                List<Partner> partners = new ArrayList<>();
                partners.add(partner);
                partnerStringMap.put(distance, partners);
            }
        }
        List<Partner> partnerList = partnerStringMap.get(0);
        Partner partner1 = Collections.min(partnerList);

        Order order = new Order();
        order.setId(orderId);
        order.setPartner(partner1);
        order.setCustomer(customer);
        order.setResturant(resturant);

        return order;
    }

    public Double getDistance(Address l1, Address l2) {
        Double x1 = l1.getLangitude();
        Double y1 = l1.getLatitude();
        Double x2 = l2.getLangitude();
        Double y2 = l2.getLatitude();
        return (Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
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
