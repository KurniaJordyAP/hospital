package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.entity.Specialization;
import id.co.indivara.miniproject.hospital.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;

    @PostMapping("/specialization/save")
    public ResponseEntity<Specialization> saveSpecialization(@RequestBody Specialization specialization){
        return new ResponseEntity<>(specializationService.save(specialization), HttpStatus.OK);
    }

    @GetMapping("/specialization/all")
    public ResponseEntity<List<Specialization>> findAllSpecialization(){
        return new ResponseEntity<>(specializationService.findAll(), HttpStatus.OK);
    }

    @PatchMapping("/specialization/{id}")
    public ResponseEntity<Specialization> updateSpecialization(@RequestBody Specialization specialization,@PathVariable("id") Long specializationId ){
        return new ResponseEntity<>(specializationService.update(specializationId,specialization), HttpStatus.OK);
    }

    @GetMapping("/specialization/{id}")
    public ResponseEntity<Specialization> findSpecialization(@PathVariable("id") Long specializationId){
        return new ResponseEntity<>(specializationService.findById(specializationId), HttpStatus.OK);
    }

    @DeleteMapping("/specialization/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") Long specializationId){
        specializationService.delete(specializationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
