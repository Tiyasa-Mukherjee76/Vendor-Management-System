package com.jstigers.services;


import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jstigers.exception.VendorException;
import com.jstigers.model.Vendor;
import com.jstigers.repository.VendorRepository;


@Service
public class VendorServiceImpl implements VendorService {
   

    @Autowired
    private  VendorRepository vendorRepository;
    
    @Override
	public Vendor createVendor(Vendor vendor) throws VendorException {
	      return vendorRepository.save(vendor);
    }
    
	@Override
	public Vendor updateVendor(Integer id, Vendor vendor) throws VendorException {
	
		 // Perform any validation here
        Vendor existingVendor = vendorRepository.findById(id)
            .orElseThrow(() -> new VendorException("Vendor not found with id " + id));

        existingVendor.setName(vendor.getName());
        existingVendor.setBankAccountNo(vendor.getBankAccountNo());
        existingVendor.setBankName(vendor.getBankName());
        existingVendor.setAddressLine1(vendor.getAddressLine1());
        existingVendor.setAddressLine2(vendor.getAddressLine2());
        existingVendor.setCity(vendor.getCity());
        existingVendor.setCountry(vendor.getCountry());
        existingVendor.setZipCode(vendor.getZipCode());

        return vendorRepository.save(existingVendor);
	}
    
	

	@Override
	public Vendor getVendorById(Integer  id) throws VendorException {
	
	   return  vendorRepository.findById(id).orElseThrow(() -> new VendorException("Vendor not found with given id " + id));
	}
    
    

	@Override
	public String deleteVendor(Integer id) throws VendorException {
	                   
		String message=" Vender is not deleted from database ";
		
	Optional<Vendor>opt=	vendorRepository.findById(id);
	
	if(opt.isEmpty()) throw  new VendorException("Vendor not found with given id " + id);
	
	else {
		
		vendorRepository.delete(opt.get());
	message=" Vender is deleted from database ";
		
	}
	
	return message;

		
	}
  

//	@Override
//	public List<Vendor> getAllVendors(Integer pageNo, Integer pageSize) throws VendorException {
//	    if (pageNo <= 0 || pageSize <= 0) {
//	        throw new VendorException("Invalid page number or page size");
//	    }
//	    Pageable pageable =  PageRequest.of(pageNo - 1, pageSize, Sort.by("name"));
//	    Page<Vendor> pagedResult = vendorRepository.findAll(pageable);
//	    List<Vendor> vendorList = pagedResult.getContent();
//	    if (vendorList.isEmpty()) {
//	        throw new VendorException("No vendors found");
//	    }
//	    return vendorList;
//	}




	

	

	

	

	
}
