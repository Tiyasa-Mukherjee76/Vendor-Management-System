package com.jstigers.services;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.jstigers.exception.VendorException;
import com.jstigers.model.Vendor;
import com.jstigers.repository.VendorRepository;

@Service
public interface VendorService {
	
	
	 Vendor createVendor(Vendor vendor) throws VendorException;
	    Vendor updateVendor(Integer id, Vendor vendor)throws VendorException;
	    String deleteVendor(Integer id)throws VendorException;
	    Vendor getVendorById(Integer  id)throws VendorException;
	  //  List<Vendor> getAllVendors(Integer pageNo, Integer pageSize)throws VendorException;
	
	/*
    @Autowired
    private VendorRepository vendorRepository;

    public Vendor createVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    public void deleteVendor(Integer vendorId) {
        vendorRepository.deleteById(vendorId);
    }

    public Optional<Vendor> getVendor(Integer vendorId) {
        return vendorRepository.findById(vendorId);
    }

    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

//    public Page<Vendor> getVendorsPaginated(int pageNo, int pageSize) {
//        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//        return vendorRepository.findAll(pageable);
//    }
 * 
 * 
 * 
 * 
 */
	
	
	
	
	
	
}
