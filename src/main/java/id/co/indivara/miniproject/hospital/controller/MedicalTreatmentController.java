package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.entity.MedicalTreatment;
import id.co.indivara.miniproject.hospital.service.MedicalTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicalTreatmentController {
    @Autowired
    private MedicalTreatmentService medicalTreatmentService;

    @PostMapping("/medical/treatment")
    MedicalTreatment saveAppointment(@RequestBody MedicalTreatment medicalTreatment){
        return medicalTreatmentService.save(medicalTreatment);
    }

}
