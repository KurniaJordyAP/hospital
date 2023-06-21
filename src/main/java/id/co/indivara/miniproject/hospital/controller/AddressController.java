package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.entity.Address;
import id.co.indivara.miniproject.hospital.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/address/save")
    public Address saveAddress(@RequestBody Address address){
        return addressService.save(address);
    }

    @GetMapping("/address/all")
    public List<Address> findAllAddress(){
        return addressService.findAll();
    }

    @PatchMapping("/address/{id}")
    public Address updateAddress(@RequestBody Address address,@PathVariable("id") Long addressId ){
        return addressService.update(addressId,address);
    }

    @GetMapping("/address/{id}")
    public Address findAddress(@PathVariable("id") Long addressId){
        return addressService.findById(addressId);
    }

    @DeleteMapping("/address/delete/{id}")
    public String deleteAddress(@PathVariable("id") Long addressId){
        addressService.delete(addressId);
        return "Delete Sukses";
    }
}
