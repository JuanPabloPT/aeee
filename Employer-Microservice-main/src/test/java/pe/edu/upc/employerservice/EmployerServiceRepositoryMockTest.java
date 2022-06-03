package pe.edu.upc.employerservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pe.edu.upc.employerservice.entity.Company;
import pe.edu.upc.employerservice.entity.Employer;
import pe.edu.upc.employerservice.entity.Sector;
import pe.edu.upc.employerservice.repository.CompanyRepository;
import pe.edu.upc.employerservice.repository.EmployerRepository;
import pe.edu.upc.employerservice.repository.SectorRepository;

@DataJpaTest
public class EmployerServiceRepositoryMockTest {
    @Autowired
    private SectorRepository sectorRepository;
    @Autowired
    private EmployerRepository employerRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Test
    public void testing(){
        Sector sector = Sector.builder().name("Software")
                .description("Desarrollo de Software para empresas inovadoras!")
                .build();
        sectorRepository.save(sector);

        Employer employer = Employer.builder()
                .firstName("Djalma")
                .lastName("Dioses")
                .dni("75411666L")
                .email("dioses1302@gmail.com")
                .numberPhone("990679544L")
                .password("djalma")
                .build();
        employerRepository.save(employer);

        Company company = Company.builder()
                .employer(employerRepository.getById(1L))
                .name("SCompany")
                .description("Software Company Development")
                .country("Peru")
                .city("Lima")
                .district("Lima Center")
                .sector(sectorRepository.getById(1L))
                .logo("my.logo.com")
                .direction("Aven. Alfonso Ugarte")
                .ruc("241324234243L")
                .build();

        companyRepository.save(company);

        Company testCompany = companyRepository.getById(1L);
        Employer testEmployer = employerRepository.getById(1L);
        Sector testSector = sectorRepository.getById(1L);
        Assertions.assertThat(testCompany.getSector().getName()).isEqualTo(testSector.getName());
        Assertions.assertThat(testCompany.getEmployer().getDni()).isEqualTo(testEmployer.getDni());
    }
}
