package pe.edu.upc.employerservice.service;

import pe.edu.upc.employerservice.entity.Company;
import pe.edu.upc.employerservice.entity.Sector;

import java.util.List;

public interface CompanyService {
    public List<Company> listAllCompany();
    public Company getCompany(Long id);
    public Company createCompany(Company company);
    public Company updateCompany(Company company);
    public void deleteCompany(Company company);
    public List<Company> findBySector(Sector sector);
}
