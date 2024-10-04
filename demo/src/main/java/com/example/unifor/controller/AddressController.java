package com.example.unifor.controller;

import com.example.unifor.entity.Address;
import com.example.unifor.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAllAddress(){
        return addressService.findAllAddress();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable Long id){
        return addressService.findAddressById(id)
                .map(address -> new ResponseEntity<>(address, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    // @PutMapping("/{id}")

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable Long id){
        addressService.deleteAddress(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
