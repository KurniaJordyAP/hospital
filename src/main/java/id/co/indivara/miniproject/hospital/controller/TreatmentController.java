package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponseTreatmentList;
import id.co.indivara.miniproject.hospital.entity.Treatment;
import id.co.indivara.miniproject.hospital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @PostMapping("/treatment/save")
    public Treatment saveTreatment(@RequestBody Treatment treatment){
        return treatmentService.save(treatment);
    }

    @GetMapping("/treatment/all")
    public List<ResponseTreatmentList> viewTreatmentList(){
        return treatmentService.viewTreatmentList();
    }

    @PatchMapping("/treatment/{id}")
    public Treatment updateTreatment(@RequestBody Treatment treatment,@PathVariable("id") Long treatmentId ){
        return treatmentService.update(treatmentId,treatment);
    }

    @GetMapping("/treatment/{id}")
    public Treatment findTreatment(@PathVariable("id") Long treatmentId){
        return treatmentService.findById(treatmentId);
    }

    @DeleteMapping("/treatment/delete/{id}")
    public String deleteTreatment(@PathVariable("id") Long treatmentId){
        treatmentService.delete(treatmentId);
        return "Delete Sukses";
    }
}
