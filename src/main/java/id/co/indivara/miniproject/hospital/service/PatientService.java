package id.co.indivara.miniproject.hospital.service;

import id.co.indivara.miniproject.hospital.entity.Address;
import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.repo.DoctorRepository;
import id.co.indivara.miniproject.hospital.repo.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService extends GenericService<Patient>{
    private PatientRepository patientRepository;
    private AddressService addressService;

    @Override
    public Patient save(Patient patient){
        Address address = addressService.findById(patient.getAddress().getAddressId());
        patient.setAddress(address);
        return patientRepository.save(patient);
    }
}
