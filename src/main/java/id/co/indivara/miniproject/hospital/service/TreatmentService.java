package id.co.indivara.miniproject.hospital.service;

import id.co.indivara.miniproject.hospital.dto.response.ResponseTreatmentList;
import id.co.indivara.miniproject.hospital.entity.Treatment;

import id.co.indivara.miniproject.hospital.repo.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TreatmentService extends GenericService<Treatment>{
    private final TreatmentRepository treatmentRepository;
    public List<ResponseTreatmentList> viewTreatmentList(){
        List<Treatment> treatments = treatmentRepository.findAll();
        List<ResponseTreatmentList> responseTreatmentList = treatments.stream().map(treatment -> new ResponseTreatmentList(treatment.getTreatmentId(), treatment.getTreatmentName())
        ).collect(Collectors.toList());
        return responseTreatmentList;
    }

}
