package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponsePatientMedicalRecord;
import id.co.indivara.miniproject.hospital.entity.MedicalTreatment;
import id.co.indivara.miniproject.hospital.service.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalTreatmentController {
    @Autowired
    private MedicalTreatmentService medicalTreatmentService;

    @PostMapping("/medical/treatment/save")
    MedicalTreatment saveAppointment(@RequestBody MedicalTreatment medicalTreatment){
        return medicalTreatmentService.save(medicalTreatment);
    }

    @GetMapping("/medical/history/{patientId}")
    List<ResponsePatientMedicalRecord> viewPatientMedicalRecord(@PathVariable("patientId") Long patientId){
        return medicalTreatmentService.viewPatientMedicalRecord(patientId);
    }


}
