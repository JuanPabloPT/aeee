package pe.edu.pe.postulation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.pe.postulation.entity.PostulantsCV;

public interface PostulantsRepository extends JpaRepository<PostulantsCV,Long> {

}
