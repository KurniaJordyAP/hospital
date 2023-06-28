package id.co.indivara.miniproject.hospital.service;

import id.co.indivara.miniproject.hospital.dto.response.ResponseAppointmentDoctor;
import id.co.indivara.miniproject.hospital.entity.Appointment;
import id.co.indivara.miniproject.hospital.entity.Doctor;
import id.co.indivara.miniproject.hospital.entity.MedicalRecord;
import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.repo.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AppointmentService extends GenericService<Appointment> {

    private final AppointmentRepository appointmentRepository;
    private final DoctorService doctorService;
    private final PatientService patientService;

    @Override
    public Appointment save(Appointment appointment) {
        MedicalRecord medicalRecord = new MedicalRecord();
        Doctor doctor = doctorService.findById(appointment.getDoctor().getDoctorId());
        Patient patient = patientService.findById(appointment.getPatient().getPatientId());
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        medicalRecord.setAppointment(appointment);
        appointment.setMedicalRecord(medicalRecord);
        return appointmentRepository.save(appointment);
    }

//    public List<ResponseAppointmentDoctor> viewAppointmentByDoctorId(Long doctorId, String date) {
//        List<Appointment> appointments = appointmentRepository.viewAppointmentByDoctorId(doctorId,date);
//        List<ResponseAppointmentDoctor> responseAppointmentDoctors = appointments.stream().map(appointment -> new ResponseAppointmentDoctor(appointment.getAppointmentId(), appointment.getPatient().getPatientName(), appointment.getSymptoms(),appointment.getPatient().getBloodType(),appointment.getStartTime(),appointment.getEndTime())
//        ).collect(Collectors.toList());
//        return responseAppointmentDoctors;
//    }

    public List<ResponseAppointmentDoctor> findByDoctorDoctorIdAndDate(Long doctorId, String date){
        List<Appointment> appointments = appointmentRepository.findByDoctorDoctorIdAndDate(doctorId,date);
        List<ResponseAppointmentDoctor> responseAppointmentDoctors = appointments.stream().map(appointment -> new ResponseAppointmentDoctor(appointment.getAppointmentId(), appointment.getPatient().getPatientName(), appointment.getSymptoms(),appointment.getPatient().getBloodType(),appointment.getStartTime(),appointment.getEndTime())
        ).collect(Collectors.toList());
        return responseAppointmentDoctors;
    }


}
