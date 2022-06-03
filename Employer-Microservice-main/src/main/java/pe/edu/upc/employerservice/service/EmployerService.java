package pe.edu.upc.employerservice.service;

import pe.edu.upc.employerservice.entity.Company;
import pe.edu.upc.employerservice.entity.Employer;

import java.util.List;

public interface EmployerService {
    public List<Employer> listAllEmployer();
    public Employer getEmployer(Long id);
    public Employer createEmployer(Employer employer);
    public Employer updateEmployer(Employer employer);
    public void deleteEmployer(Employer employer);
}
