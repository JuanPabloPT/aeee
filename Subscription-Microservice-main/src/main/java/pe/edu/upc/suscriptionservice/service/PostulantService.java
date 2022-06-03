package pe.edu.upc.suscriptionservice.service;

import pe.edu.upc.suscriptionservice.entity.Postulant;

import java.util.List;

public interface PostulantService {
    public List<Postulant> getAllPostulant();
    public Postulant getPostulant(Long id);
    public Postulant createPostulant(Postulant postulant);
    public Postulant updatePostulant(Postulant postulant);
    public void deletePostulant(Postulant company);
}
