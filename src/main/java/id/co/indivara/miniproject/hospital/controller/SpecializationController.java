package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.entity.Specialization;
import id.co.indivara.miniproject.hospital.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;

    @PostMapping("/specialization/save")
    public Specialization saveSpecialization(@RequestBody Specialization specialization){
        return specializationService.save(specialization);
    }

    @GetMapping("/specialization/all")
    public List<Specialization> findAllSpecialization(){
        return specializationService.findAll();
    }

    @PatchMapping("/specialization/{id}")
    public Specialization updateSpecialization(@RequestBody Specialization specialization,@PathVariable("id") Long specializationId ){
        return specializationService.update(specializationId,specialization);
    }

    @GetMapping("/specialization/{id}")
    public Specialization findSpecialization(@PathVariable("id") Long specializationId){
        return specializationService.findById(specializationId);
    }

    @DeleteMapping("/specialization/delete/{id}")
    public String deleteDoctor(@PathVariable("id") Long specializationId){
        specializationService.delete(specializationId);
        return "Delete Sukses";
    }
}
