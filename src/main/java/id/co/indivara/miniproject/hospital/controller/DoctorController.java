package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponseDoctorList;
import id.co.indivara.miniproject.hospital.entity.Doctor;
import id.co.indivara.miniproject.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor){
        return doctorService.save(doctor);
    }

    @GetMapping("/doctor/all")
    public List<ResponseDoctorList> viewDoctorList(){
        return doctorService.viewDoctorList();
    }

    @PatchMapping("/doctor/{id}")
    public Doctor updateDoctor(@RequestBody Doctor doctor,@PathVariable("id") Long doctorId ){
        return doctorService.update(doctorId,doctor);
    }

    @GetMapping("/doctor/{id}")
    public Doctor findDoctor(@PathVariable("id") Long doctorId){
        return doctorService.findById(doctorId);
    }

    @DeleteMapping("/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable("id") Long doctorId){
        doctorService.delete(doctorId);
        return "Delete Sukses";
    }

}
