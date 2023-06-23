package id.co.indivara.miniproject.hospital.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTreatmentList {
    @Column(name = "treatment_id")
    private Long treatmentID;
    @Column(name = "treatment_name")
    private String treatmentName;
}
