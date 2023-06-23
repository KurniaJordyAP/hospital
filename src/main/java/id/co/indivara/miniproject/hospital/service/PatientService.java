package id.co.indivara.miniproject.hospital.service;

import id.co.indivara.miniproject.hospital.dto.response.ResponsePatientList;
import id.co.indivara.miniproject.hospital.entity.Address;
import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.repo.DoctorRepository;
import id.co.indivara.miniproject.hospital.repo.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientService extends GenericService<Patient>{
    private final PatientRepository patientRepository;
    private final AddressService addressService;

    @Override
    public Patient save(Patient patient){
        Address address = patient.getAddress();
        patient.setAddress(address);
        return patientRepository.save(patient);
    }


    public List<ResponsePatientList> viewPatientList() {
        List<Patient> patients = patientRepository.viewPatientList();
        List<ResponsePatientList> responsePatientLists = patients.stream().map(patient -> new ResponsePatientList(patient.getPatientId(), patient.getPatientName(), patient.getNoKtp(), patient.getBloodType(), patient.getGender())
        ).collect(Collectors.toList());
        return responsePatientLists;
    }
}
