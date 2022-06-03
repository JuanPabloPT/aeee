package pe.edu.upc.suscriptionservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.suscriptionservice.entity.Postulant;
import pe.edu.upc.suscriptionservice.repository.PostulantRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class PostulantServiceImplementation implements PostulantService {

    @Autowired
    private PostulantRepository postulantRepository;

    @Override
    public List<Postulant> getAllPostulant() {
        List<Postulant> postulantList = postulantRepository.findAll();
        if(postulantList == null) return null;
        return postulantList;
    }

    @Override
    public Postulant getPostulant(Long id) {
        Postulant postulant = postulantRepository.findById(id).orElse(null);
        if(postulant == null) return null;
        return postulant;
    }

    @Override
    public Postulant createPostulant(Postulant postulant) {
        if(postulant == null) return null;
        return postulantRepository.save(postulant);
    }

    @Override
    public Postulant updatePostulant(Postulant postulant) {
        if(postulant == null) return null;
        Postulant postulantDB = postulantRepository.findById(postulant.getId()).orElse(null);
        postulantDB.setEmail(postulant.getEmail());
        postulantDB.setFirstName(postulant.getFirstName());
        postulantDB.setLastName(postulant.getLastName());
        postulantDB.setDocument(postulant.getDocument());
        postulantDB.setPassword(postulant.getPassword());
        postulantDB.setBirthday(postulant.getBirthday());
        postulantDB.setCivilStatus(postulant.getCivilStatus());
        postulantDB.setNumber(postulant.getFirstName());
        return postulantRepository.save(postulantDB);
    }

    @Override
    public void deletePostulant(Postulant postulant) {
        if(postulant == null) return;
        postulantRepository.delete(postulant);
    }
}
