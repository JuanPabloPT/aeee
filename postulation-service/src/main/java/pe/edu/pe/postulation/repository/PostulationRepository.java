package pe.edu.pe.postulation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pe.postulation.entity.Postulation;

import java.util.List;

public interface PostulationRepository extends JpaRepository<Postulation,Long> {
    public Postulation findByNumberPostulation(String numberPostulation);
    public List<Postulation> findByPostulantId(Long cvId);
    public Postulation findByJobOfferId(Long jobOfferId);
}
