package id.co.indivara.miniproject.hospital.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "mst_patient")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_birth")
    private LocalDate patientBirth;
    @Column(name = "no_ktp")
    private String noKtp;
    @Column(name = "blood_type")
    private String bloodType;
    @Column(name = "gender")
    private String gender;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
}
