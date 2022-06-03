package pe.edu.upc.employerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.employerservice.entity.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long> {
}
