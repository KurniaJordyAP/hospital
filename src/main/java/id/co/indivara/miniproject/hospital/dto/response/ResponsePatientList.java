package id.co.indivara.miniproject.hospital.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePatientList {
    @JsonProperty("patient_id")
    private Long patientId;
    @JsonProperty("patient_name")
    private String patientName;
    @JsonProperty("no_ktp")
    private String noKtp;
    @JsonProperty("blood_type")
    private String bloodType;
    @JsonProperty("gender")
    private String gender;

}
