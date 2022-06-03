package pe.edu.upc.suscriptionservice.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.suscriptionservice.entity.Employer;
import pe.edu.upc.suscriptionservice.repository.EmployerRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EmployerServiceImplementation implements EmployerService {
    @Autowired
    private EmployerRepository employerRepository;
    @Override
    public List<Employer> getAllEmployer() {
        List<Employer> employerList = employerRepository.findAll();
        if(employerList == null) return null;
        return employerList;
    }

    @Override
    public Employer getEmployer(Long id) {
        Employer employer = employerRepository.findById(id).orElse(null);
        if(employer == null) return null;
        return employer;
    }

    @Override
    public Employer createEmployer(Employer employer) {
        if(employer == null) return null;
        return employerRepository.save(employer);
    }

    @Override
    public Employer updateEmployer(Employer employer) {
        if(employer == null) return null;
        Employer employerDB = employerRepository.findById(employer.getId()).orElse(null);
        employerDB.setEmail(employer.getEmail());
        employerDB.setFirstName(employer.getFirstName());
        employerDB.setLastName(employer.getLastName());
        employerDB.setDni(employer.getDni());
        employerDB.setPassword(employer.getPassword());
        employerDB.setNumberPhone(employer.getNumberPhone());
        return employerRepository.save(employerDB);
    }

    @Override
    public void deleteEmployer(Employer employer) {
        if(employer == null) return;
        employerRepository.delete(employer);
    }
}
