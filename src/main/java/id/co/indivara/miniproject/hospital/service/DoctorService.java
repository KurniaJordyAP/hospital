package id.co.indivara.miniproject.hospital.service;

import id.co.indivara.miniproject.hospital.entity.Address;
import id.co.indivara.miniproject.hospital.entity.Doctor;
import id.co.indivara.miniproject.hospital.entity.Specialization;
import id.co.indivara.miniproject.hospital.repo.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService extends GenericService<Doctor>{
    private final DoctorRepository doctorRepository;
    private final SpecializationService specializationService;
    private final AddressService addressService;

    @Override
    public Doctor save(Doctor doctor) {
        System.out.println("test ");
        Specialization specialization = specializationService.findById(doctor.getSpecialization().getSpecializationId());
        Address address = doctor.getAddress();
        doctor.setSpecialization(specialization);
        doctor.setAddress(address);
        System.out.println(doctor);
        return doctorRepository.save(doctor);
    }
}

