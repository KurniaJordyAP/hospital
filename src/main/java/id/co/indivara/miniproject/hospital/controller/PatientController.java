package id.co.indivara.miniproject.hospital.controller;


import id.co.indivara.miniproject.hospital.dto.response.ResponsePatientList;
import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/patient/save")
    public Patient savePatient(@RequestBody Patient patient){
        return patientService.save(patient);
    }

    @GetMapping("/patient/all")
    public List<ResponsePatientList> viewPatientList(){
        return patientService.viewPatientList();
    }

    @PatchMapping("/patient/{id}")
    public Patient updatePatient(@RequestBody Patient patient,@PathVariable("id") Long patientId ){
        return patientService.update(patientId,patient);
    }

    @GetMapping("/patient/{id}")
    public Patient findPatient(@PathVariable("id") Long patientId){
        return patientService.findById(patientId);
    }

    @DeleteMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Long patientId){
        patientService.delete(patientId);
        return "Delete Sukses";
    }

}
