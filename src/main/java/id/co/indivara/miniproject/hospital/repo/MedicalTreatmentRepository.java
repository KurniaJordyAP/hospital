package id.co.indivara.miniproject.hospital.repo;

import id.co.indivara.miniproject.hospital.entity.MedicalTreatment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalTreatmentRepository extends GenericRepository<MedicalTreatment>{

    //MENGGUNAKAN NATIVE QUERY
//    @Query(value = "SELECT * FROM trx_medical_treatment a "+
//            "JOIN trx_medical_record b ON a.medical_record_id = b.medical_record_id "+
//            "JOIN trx_appointment c ON b.appointment_id = c.appointment_id "+
//            "WHERE c.patient_id = :patientId ", nativeQuery = true)
//    List<MedicalTreatment> viewPatientMedicalRecord(@Param("patientId") Long patientId);


    //MENGGUNAKAN JPQL Query
//    @Query(value = "SELECT a FROM MedicalTreatment a "+
//            "JOIN MedicalRecord b ON a.medicalRecord.medicalRecordId = b.medicalRecordId "+
//            "JOIN Appointment c ON b.appointment.appointmentId = c.appointmentId "+
//            "WHERE c.patient.patientId = :patientId ")
//    List<MedicalTreatment> viewPatientMedicalRecord1(@Param("patientId") Long patientId);

    List<MedicalTreatment> findByMedicalRecordAppointmentPatientPatientId(Long patientId);
}
