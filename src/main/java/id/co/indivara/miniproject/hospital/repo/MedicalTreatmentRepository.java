package id.co.indivara.miniproject.hospital.repo;

import id.co.indivara.miniproject.hospital.entity.MedicalTreatment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalTreatmentRepository extends GenericRepository<MedicalTreatment>{

    @Query(value = "SELECT * FROM trx_medical_treatment a "+
            "JOIN trx_medical_record b ON a.medical_record_id = b.medical_record_id "+
            "JOIN trx_appointment c ON b.appointment_id = c.appointment_id "+
            "WHERE c.patient_id = :patientId ", nativeQuery = true)
    List<MedicalTreatment> viewPatientMedicalRecord(@Param("patientId") Long patientId);
}
