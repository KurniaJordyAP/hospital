package id.co.indivara.miniproject.hospital.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import id.co.indivara.miniproject.hospital.entity.Specialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDoctorList {
    @JsonProperty("doctor_id")
    private Long doctorId;
    @JsonProperty("registration_id")
    private Long registrationId;
    @JsonProperty("doctor_name")
    private String doctorName;
    @JsonProperty("specialization_id")
    private Specialization specialization;
    @JsonProperty("gender")
    private String gender;

}
