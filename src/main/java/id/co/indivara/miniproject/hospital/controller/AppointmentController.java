package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponseAppointmentDoctor;
import id.co.indivara.miniproject.hospital.entity.Appointment;
import id.co.indivara.miniproject.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment/save")
    Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentService.save(appointment);
    }

    @GetMapping("/appointment/{doctorId}/{date}")
    public List<ResponseAppointmentDoctor> getAppointmentByDoctorId(@PathVariable("doctorId") Long doctorId, @PathVariable("date") Date date){
        return appointmentService.viewAppointmentByDoctorId(doctorId,date);
    }
}
