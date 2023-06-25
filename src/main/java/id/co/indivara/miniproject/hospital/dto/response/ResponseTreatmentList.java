package id.co.indivara.miniproject.hospital.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTreatmentList {
    @JsonProperty("treatment_id")
    private Long treatmentId;
    @JsonProperty("treatment_name")
    private String treatmentName;
}
