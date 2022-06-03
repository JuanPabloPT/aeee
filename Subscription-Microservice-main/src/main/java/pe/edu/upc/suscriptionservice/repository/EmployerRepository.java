package pe.edu.upc.suscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.suscriptionservice.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
