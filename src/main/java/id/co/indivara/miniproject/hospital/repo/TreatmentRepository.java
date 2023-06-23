package id.co.indivara.miniproject.hospital.repo;

import id.co.indivara.miniproject.hospital.entity.Patient;
import id.co.indivara.miniproject.hospital.entity.Treatment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentRepository extends GenericRepository<Treatment>{
    @Query(value = "SELECT * FROM mst_treatment", nativeQuery = true)
    List<Treatment> viewTreatmentList();
}
