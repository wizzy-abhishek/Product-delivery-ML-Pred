package com.ecom.delivery.service.impl;

import com.ecom.delivery.dto.registration.VendorRequestDTO;
import com.ecom.delivery.repo.VendorRepo;
import com.ecom.delivery.service.VendorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VendorServiceImpl implements VendorService {

    private final VendorRepo vendorRepo;

    @Override
    public String addVendor(VendorRequestDTO vendorDTO) {

        return "";
    }
}
