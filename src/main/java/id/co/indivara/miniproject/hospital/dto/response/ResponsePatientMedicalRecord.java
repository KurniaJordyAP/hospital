package id.co.indivara.miniproject.hospital.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePatientMedicalRecord {
    @JsonProperty("medical_record_id")
    private Long medicalRecordId;
    @JsonProperty("doctor_name")
    private String doctorName;
    @JsonProperty("patient_name")
    private String patientName;
    @JsonProperty("symptoms")
    private String symptoms;
    @JsonProperty("treatment_name")
    private String treatmentName;
    @JsonProperty("note")
    private String note;
}
