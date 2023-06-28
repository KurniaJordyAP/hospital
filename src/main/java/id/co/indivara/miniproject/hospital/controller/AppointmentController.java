package id.co.indivara.miniproject.hospital.controller;

import id.co.indivara.miniproject.hospital.dto.response.ResponseAppointmentDoctor;
import id.co.indivara.miniproject.hospital.entity.Appointment;
import id.co.indivara.miniproject.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/appointment/save")
    ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment){
        return new ResponseEntity<>(appointmentService.save(appointment), HttpStatus.OK);
    }

    @GetMapping("/appointment/{doctorId}/{date}")
    public ResponseEntity<List<ResponseAppointmentDoctor>> getAppointmentByDoctorId(@PathVariable("doctorId") Long doctorId, @PathVariable("date") String date){
        return new ResponseEntity<>(appointmentService.findByDoctorDoctorIdAndDate(doctorId,date), HttpStatus.OK);
    }

    @PatchMapping("/appointment/update/{id}")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment,@PathVariable("id") Long appointmentId){
        return new ResponseEntity<>(appointmentService.update(appointmentId, appointment), HttpStatus.OK);
    }
}
