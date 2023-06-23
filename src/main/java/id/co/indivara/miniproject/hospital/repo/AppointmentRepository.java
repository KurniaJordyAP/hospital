package id.co.indivara.miniproject.hospital.repo;

import id.co.indivara.miniproject.hospital.entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface AppointmentRepository extends GenericRepository<Appointment>{
    @Query(value = "SELECT a.appointment_id, a.patient_id, a.date, a.symptoms, a.start_time, a.end_time, a.appointment_status,a.doctor_id " +
            "FROM trx_appointment a " +
            "JOIN mst_doctor d ON a.doctor_id = d.doctor_id " +
            "WHERE d.doctor_id = :doctorId and a.date=:date", nativeQuery = true)
    List<Appointment> viewAppointmentByDoctorId(@Param("doctorId") Long doctorId,@Param("date") Date date);
}
