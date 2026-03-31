package com.ecom.delivery.service.impl;

import com.ecom.delivery.dto.registration.VendorRegistrationDTO;
import com.ecom.delivery.entity.Address;
import com.ecom.delivery.entity.Vendor;
import com.ecom.delivery.repo.AddressRepo;
import com.ecom.delivery.repo.VendorRepo;
import com.ecom.delivery.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepo vendorRepo;
    private final AddressRepo addressRepo;

    @Override
    public String addVendor(VendorRegistrationDTO vendorDTO) {
        Address address = new Address(vendorDTO.addressDTO().district(),
                vendorDTO.addressDTO().state(),
                vendorDTO.addressDTO().pincode());
        address = addressRepo.save(address);
        Vendor vendor = new Vendor(vendorDTO.gstNumber(), vendorDTO.name(), address);
        vendor = vendorRepo.save(vendor);
        return vendor.getId().toString();
    }
}
