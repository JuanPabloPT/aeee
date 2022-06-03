package pe.edu.upc.suscriptionservice.service;

import pe.edu.upc.suscriptionservice.entity.Employer;
import pe.edu.upc.suscriptionservice.entity.Postulant;

import java.util.List;

public interface EmployerService {
    public List<Employer> getAllEmployer();
    public Employer getEmployer(Long id);
    public Employer createEmployer(Employer employer);
    public Employer updateEmployer(Employer employer);
    public void deleteEmployer(Employer employer);
}
