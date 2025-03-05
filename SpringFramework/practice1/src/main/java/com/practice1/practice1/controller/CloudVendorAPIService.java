package com.practice1.practice1.controller;

import com.practice1.practice1.model.CloudVendor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cloudvendor") // context path
public class CloudVendorAPIService {

    CloudVendor cloudVendor;

    @GetMapping("{vendorID}")
    public CloudVendor getCloudVendorDetails(String vendorId){
        return cloudVendor;
//        return new CloudVendor("C1", "AAA", "Address 1",
//                "12345");
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud vendor Created successfully";
    }
    @PutMapping
    public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        this.cloudVendor = cloudVendor;
        return "Cloud vendor Updated successfully";
    }

    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(String vendorId){
        this.cloudVendor = null;
        return "Cloud vendor deleted successfully";
    }
}