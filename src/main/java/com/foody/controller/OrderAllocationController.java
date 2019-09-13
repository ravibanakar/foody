package com.foody.controller;

import com.foody.service.OpenStreetMapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OrderAllocationController {

    @Autowired
    private OpenStreetMapUtils openStreetMapUtils;

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    public Map<String, Double> getCoordinates(@RequestParam (value = "address") String address) {
        return openStreetMapUtils.getCoordinates(address);
    }
}
