package id.co.indivara.miniproject.hospital.controller;


import id.co.indivara.miniproject.hospital.dto.response.ResponsePatientList;
import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/patient/save")
    public ResponseEntity<Patient> savePatient(@RequestBody Patient patient){
        return new ResponseEntity<>(patientService.save(patient), HttpStatus.OK);
    }

    @GetMapping("/patient/all")
    public ResponseEntity<List<ResponsePatientList>> viewPatientList(){
        return new ResponseEntity<>(patientService.viewPatientList(), HttpStatus.OK);
    }

    @PatchMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient,@PathVariable("id") Long patientId ){
        return new ResponseEntity<>(patientService.update(patientId,patient), HttpStatus.OK);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> findPatient(@PathVariable("id") Long patientId){
        return new ResponseEntity<>(patientService.findById(patientId), HttpStatus.OK);
    }

    @DeleteMapping("/patient/delete/{id}")
    public ResponseEntity<HttpStatus> deletePatient(@PathVariable("id") Long patientId){
        patientService.delete(patientId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
