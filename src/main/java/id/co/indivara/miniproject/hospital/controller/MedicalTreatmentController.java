package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponsePatientMedicalRecord;
import id.co.indivara.miniproject.hospital.entity.MedicalTreatment;
import id.co.indivara.miniproject.hospital.service.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalTreatmentController {
    @Autowired
    private MedicalTreatmentService medicalTreatmentService;

    @PostMapping("/medical/treatment/save")
    ResponseEntity<MedicalTreatment> saveAppointment(@RequestBody MedicalTreatment medicalTreatment){
        return new ResponseEntity<>(medicalTreatmentService.save(medicalTreatment), HttpStatus.OK);
    }

    @GetMapping("/medical/history/{patientId}")
    ResponseEntity<List<ResponsePatientMedicalRecord>> viewPatientMedicalRecord(@PathVariable("patientId") Long patientId){
        return new ResponseEntity<>(medicalTreatmentService.findByMedicalRecordAppointmentPatientPatientId(patientId), HttpStatus.OK);
    }


}
