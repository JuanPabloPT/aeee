package pe.edu.upc.suscriptionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.suscriptionservice.entity.Postulant;

public interface PostulantRepository extends JpaRepository<Postulant, Long> {
}
