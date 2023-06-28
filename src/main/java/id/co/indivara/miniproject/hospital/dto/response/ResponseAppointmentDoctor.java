package id.co.indivara.miniproject.hospital.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Time;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAppointmentDoctor {
    @JsonProperty("appointment_id")
    private Long appointmentId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("symptoms")
    private String symptoms;
    @JsonProperty("golongan_darah")
    private String golonganDarah;
    @JsonProperty("start_time")
    private Time startTime;
    @JsonProperty("end_time")
    private Time endTime;
}
