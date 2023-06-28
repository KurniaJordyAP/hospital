package id.co.indivara.miniproject.hospital.service;


import id.co.indivara.miniproject.hospital.dto.response.ResponsePatientMedicalRecord;
import id.co.indivara.miniproject.hospital.entity.MedicalRecord;
import id.co.indivara.miniproject.hospital.entity.MedicalTreatment;
import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.entity.Treatment;
import id.co.indivara.miniproject.hospital.repo.MedicalTreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    //JIKA MEMAKAI QUERY JPQL ATAU NATIVE
//    public List<ResponsePatientMedicalRecord> viewPatientMedicalRecord1(Long patientId){
//        List<MedicalTreatment> medicalTreatments = medicalTreatmentRepository.viewPatientMedicalRecord1(patientId);
//        List<ResponsePatientMedicalRecord> responsePatientMedicalRecords = medicalTreatments.stream().map(
//                medicalTreatment -> new ResponsePatientMedicalRecord(
//                        medicalTreatment.getMedicalRecord().getMedicalRecordId(),
//                        medicalTreatment.getMedicalRecord().getAppointment().getDate(),
//                        medicalTreatment.getMedicalRecord().getAppointment().getDoctor().getDoctorName(),
//                        medicalTreatment.getMedicalRecord().getAppointment().getPatient().getPatientName(),
//                        medicalTreatment.getMedicalRecord().getAppointment().getSymptoms(),
//                        medicalTreatment.getTreatment().getTreatmentName(),
//                        medicalTreatment.getNote()
//                )
//        ).collect(Collectors.toList());
//        return responsePatientMedicalRecords;
//    }

    public List<ResponsePatientMedicalRecord> findByMedicalRecordAppointmentPatientPatientId(Long patientId) {
        List<MedicalTreatment> medicalTreatments = medicalTreatmentRepository.findByMedicalRecordAppointmentPatientPatientId(patientId);
        List<ResponsePatientMedicalRecord> responsePatientMedicalRecords = medicalTreatments.stream().map(
                medicalTreatment -> new ResponsePatientMedicalRecord(
                        medicalTreatment.getMedicalRecord().getMedicalRecordId(),
                        medicalTreatment.getMedicalRecord().getAppointment().getDate(),
                        medicalTreatment.getMedicalRecord().getAppointment().getDoctor().getDoctorName(),
                        medicalTreatment.getMedicalRecord().getAppointment().getPatient().getPatientName(),
                        medicalTreatment.getMedicalRecord().getAppointment().getSymptoms(),
                        medicalTreatment.getTreatment().getTreatmentName(),
                        medicalTreatment.getNote()
                )
        ).collect(Collectors.toList());
        return responsePatientMedicalRecords;
    }
}
