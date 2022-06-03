package pe.edu.upc.employerservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.upc.employerservice.entity.Company;
import pe.edu.upc.employerservice.entity.Employer;
import pe.edu.upc.employerservice.entity.Sector;
import pe.edu.upc.employerservice.repository.CompanyRepository;
import pe.edu.upc.employerservice.repository.EmployerRepository;
import pe.edu.upc.employerservice.repository.SectorRepository;
import pe.edu.upc.employerservice.service.*;

import java.util.Optional;

@SpringBootTest
public class EmployerServiceServiceMockTest {

    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private SectorRepository sectorRepository;
    @Mock
    private EmployerRepository employerRepository;

    private CompanyService companyService;
    private SectorService sectorService;
    private EmployerService employerService;
    @BeforeEach
    public void setup() {
        companyService = new CompanyServiceImplementation(companyRepository);
        sectorService = new SectorServiceImplementation(sectorRepository);
        employerService = new EmployerServiceImplementation(employerRepository);

        Sector sector = Sector.builder().name("Marketing")
                .description("Desarrollo de Marketing para empresas!")
                .build();

        Employer employer = Employer.builder()
                .firstName("Pepe")
                .lastName("Molina")
                .dni("9873452L")
                .email("pepitoloko12@gmail.com")
                .numberPhone("990543853L")
                .password("pepe")
                .build();

        Company company = Company.builder()
                .employer(employerRepository.getById(1L))
                .name("Marketing SA")
                .description("Marketing Company Development")
                .country("Peru")
                .city("Callao")
                .district("Ventanilla")
                .sector(sectorRepository.getById(1L))
                .logo("my.marketing.com/logo.png")
                .direction("Aven. Street 1.")
                .ruc("645396892L")
                .build();


        Mockito.when(sectorRepository.findById(1L))
                .thenReturn(Optional.of(sector));
        Mockito.when(sectorRepository.save(sector))
                .thenReturn(sector);

        Mockito.when(employerRepository.findById(1L))
                .thenReturn(Optional.of(employer));
        Mockito.when(employerRepository.save(employer))
                .thenReturn(employer);

        Mockito.when(companyRepository.findById(1L))
                .thenReturn(Optional.of(company));
        Mockito.when(companyRepository.save(company))
                .thenReturn(company);
    }

    @Test
    public void whenValidateGetID_ThenReturnEntity() {
        Company foundCompany = companyService.getCompany(1L);
        Sector foundSector = sectorService.getSector(1L);
        Employer foundEmployer = employerService.getEmployer(1L);

        Assertions.assertThat(foundCompany.getName()).isEqualTo("Marketing SA");
        Assertions.assertThat(foundSector.getName()).isEqualTo("Marketing");
        Assertions.assertThat(foundEmployer.getFirstName()).isEqualTo("Pepe");
        System.out.println(foundCompany.toString());
        System.out.println(foundSector.toString());
    }

}
