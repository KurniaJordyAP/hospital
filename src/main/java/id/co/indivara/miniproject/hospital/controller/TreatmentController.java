package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponseTreatmentList;
import id.co.indivara.miniproject.hospital.entity.Treatment;
import id.co.indivara.miniproject.hospital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TreatmentController {
    @Autowired
    private TreatmentService treatmentService;

    @PostMapping("/treatment/save")
    public ResponseEntity<Treatment> saveTreatment(@RequestBody Treatment treatment){
        return new ResponseEntity<>(treatmentService.save(treatment), HttpStatus.OK);
    }

    @GetMapping("/treatment/all")
    public ResponseEntity<List<ResponseTreatmentList>> viewTreatmentList(){
        return new ResponseEntity<>(treatmentService.viewTreatmentList(), HttpStatus.OK);
    }

    @PatchMapping("/treatment/{id}")
    public ResponseEntity<Treatment> updateTreatment(@RequestBody Treatment treatment,@PathVariable("id") Long treatmentId ){
        return new ResponseEntity<>(treatmentService.update(treatmentId,treatment), HttpStatus.OK);
    }

    @GetMapping("/treatment/{id}")
    public ResponseEntity<Treatment> findTreatment(@PathVariable("id") Long treatmentId){
        return new ResponseEntity<>(treatmentService.findById(treatmentId), HttpStatus.OK);
    }

    @DeleteMapping("/treatment/delete/{id}")
    public ResponseEntity<HttpStatus> deleteTreatment(@PathVariable("id") Long treatmentId){
        treatmentService.delete(treatmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
