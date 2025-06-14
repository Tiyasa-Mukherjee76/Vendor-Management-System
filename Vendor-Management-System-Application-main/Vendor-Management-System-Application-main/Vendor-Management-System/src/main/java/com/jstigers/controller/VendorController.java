package com.jstigers.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jstigers.exception.VendorException;
import com.jstigers.model.Vendor;
import com.jstigers.services.VendorService;



@RestController
@RequestMapping
public class VendorController {

    @Autowired
    private VendorService vendorService;

    
    @GetMapping()
    public String welcomeMessage()  {
         return "Vendor Management System Application Is Running";
    }
    
    @PostMapping("/registor")
    public ResponseEntity<Vendor> createVendor(@Valid @RequestBody Vendor vendor) throws VendorException {
        Vendor createdVendor = vendorService.createVendor(vendor);
        return new ResponseEntity<>(createdVendor, HttpStatus.CREATED);
    }

//    @GetMapping
//    public ResponseEntity<List<Vendor>> getAllVendors(@RequestParam(defaultValue = "0") Integer pageNo,
//                                                       @RequestParam(defaultValue = "10") Integer pageSize) throws VendorException {
//        List<Vendor> vendorList = vendorService.getAllVendors(pageNo, pageSize);
//        return new ResponseEntity<>(vendorList, HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendor> getVendorById(@PathVariable("id") Integer id) throws VendorException {
        Vendor vendor = vendorService.getVendorById(id);
        return new ResponseEntity<>(vendor, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendor> updateVendor(@PathVariable("id") Integer id, @Valid @RequestBody Vendor vendor) throws VendorException {
        Vendor updatedVendor = vendorService.updateVendor(id, vendor);
        return new ResponseEntity<>(updatedVendor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteVendor(@PathVariable("id")Integer id) throws VendorException {
        vendorService.deleteVendor(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
