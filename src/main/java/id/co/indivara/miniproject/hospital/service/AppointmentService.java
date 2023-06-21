package id.co.indivara.miniproject.hospital.service;

import id.co.indivara.miniproject.hospital.entity.Appointment;
import id.co.indivara.miniproject.hospital.entity.Doctor;
import id.co.indivara.miniproject.hospital.entity.MedicalRecord;
import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.repo.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService extends GenericService<Appointment>{
    private AppointmentRepository appointmentRepository;
    private DoctorService doctorService;
    private PatientService patientService;

    @Override
    public Appointment save(Appointment appointment){
        MedicalRecord medicalRecord = new MedicalRecord();
        Doctor doctor = doctorService.findById(appointment.getDoctor().getDoctorId());
        Patient patient= patientService.findById(appointment.getPatient().getPatientId());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        medicalRecord.setAppointment(appointment);
        appointment.setMedicalRecord(medicalRecord);
        return appointmentRepository.save(appointment);
    }

}
