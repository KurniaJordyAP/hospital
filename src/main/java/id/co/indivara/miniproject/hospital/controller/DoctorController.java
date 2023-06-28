package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponseDoctorList;
import id.co.indivara.miniproject.hospital.entity.Doctor;
import id.co.indivara.miniproject.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor/save")
    public ResponseEntity<Doctor> saveDoctor(@RequestBody Doctor doctor){
        return new ResponseEntity<>(doctorService.save(doctor), HttpStatus.OK);
    }

    @GetMapping("/doctor/all")
    public ResponseEntity<List<ResponseDoctorList>> viewDoctorList(){
        return new ResponseEntity<>(doctorService.viewDoctorList(), HttpStatus.OK);
    }

    @PatchMapping("/doctor/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor,@PathVariable("id") Long doctorId ){
        return new ResponseEntity<>(doctorService.update(doctorId,doctor), HttpStatus.OK);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<Doctor> findDoctor(@PathVariable("id") Long doctorId){
        return new ResponseEntity<>(doctorService.findById(doctorId), HttpStatus.OK);
    }

    @DeleteMapping("/doctor/delete/{id}")
    public ResponseEntity<HttpStatus> deleteDoctor(@PathVariable("id") Long doctorId){
        doctorService.delete(doctorId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
