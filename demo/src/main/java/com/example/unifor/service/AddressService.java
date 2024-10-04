package com.example.unifor.service;

import com.example.unifor.entity.Address;
import com.example.unifor.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAllAddress(){
        return addressRepository.findAll();
    }

    public Optional<Address> findAddressById(Long id){
        return addressRepository.findById(id);
    }

    public Address saveAddress(Address address){
        return addressRepository.save(address);
    }

    public Address updateAddress(Long id, Address updateAddress){
        return addressRepository.findById(id)
                .map(address -> {
                    address.setStreet(updateAddress.getStreet());
                    address.setCity(updateAddress.getCity());
                    address.setState(updateAddress.getState());
                    address.setZipCode(updateAddress.getZipCode());
                    address.setUser(updateAddress.getUser());
                    return addressRepository.save(address);
                }).orElseThrow(() -> new RuntimeException("Address not found"));
    }

    public void deleteAddress(Long id){
        addressRepository.deleteById(id);
    }

}
