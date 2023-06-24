package id.co.indivara.miniproject.hospital.repo;

import id.co.indivara.miniproject.hospital.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends GenericRepository<User> {

    Optional<User> findByUsername(String username);
}
