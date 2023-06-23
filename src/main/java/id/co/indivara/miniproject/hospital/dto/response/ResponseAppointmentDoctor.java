package id.co.indivara.miniproject.hospital.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAppointmentDoctor {
    private Long appointmentId;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("name")
    private String name;
    @JsonProperty("symptoms")
    private String symptoms;
    @JsonProperty("golongan_darah")
    private String golonganDarah;
}
