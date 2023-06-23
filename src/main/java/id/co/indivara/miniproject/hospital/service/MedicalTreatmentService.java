package id.co.indivara.miniproject.hospital.service;


import id.co.indivara.miniproject.hospital.entity.MedicalRecord;
import id.co.indivara.miniproject.hospital.entity.MedicalTreatment;
import id.co.indivara.miniproject.hospital.entity.Treatment;
import id.co.indivara.miniproject.hospital.repo.MedicalTreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalTreatmentService extends GenericService<MedicalTreatment>{
    private final MedicalTreatmentRepository medicalTreatmentRepository;
    private final MedicalRecordService medicalRecordService;
    private final TreatmentService treatmentService;

    @Override
    public MedicalTreatment save(MedicalTreatment medicalTreatment){
        MedicalRecord medicalRecord = medicalRecordService.findById(medicalTreatment.getMedicalRecord().getMedicalRecordId());
        Treatment treatment= treatmentService.findById(medicalTreatment.getTreatment().getTreatmentId());
        medicalTreatment.setMedicalRecord(medicalRecord);
        medicalTreatment.setTreatment(treatment);
        return medicalTreatmentRepository.save(medicalTreatment);
    }

}
