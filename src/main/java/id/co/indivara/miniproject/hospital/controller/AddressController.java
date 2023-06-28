package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.entity.Address;
import id.co.indivara.miniproject.hospital.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/address/save")
    public ResponseEntity<Address> saveAddress(@RequestBody Address address){
        return new ResponseEntity<>(addressService.save(address), HttpStatus.OK);
    }

    @GetMapping("/address/all")
    public ResponseEntity<List<Address>> findAllAddress(){
        return new ResponseEntity<>(addressService.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/address/{id}")
    public ResponseEntity<Address> updateAddress(@RequestBody Address address,@PathVariable("id") Long addressId ){
        return new ResponseEntity<>(addressService.update(addressId,address), HttpStatus.OK) ;
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findAddress(@PathVariable("id") Long addressId){
        return new ResponseEntity<>(addressService.findById(addressId), HttpStatus.OK);
    }

    @DeleteMapping("/address/delete/{id}")
    public ResponseEntity<HttpStatus> deleteAddress(@PathVariable("id") Long addressId){
        addressService.delete(addressId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
