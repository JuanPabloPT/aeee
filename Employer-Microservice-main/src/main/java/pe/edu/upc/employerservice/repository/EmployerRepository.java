package pe.edu.upc.employerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.employerservice.entity.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
