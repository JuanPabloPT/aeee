package pe.edu.upc.suscriptionservice;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import pe.edu.upc.suscriptionservice.entity.Employer;
import pe.edu.upc.suscriptionservice.entity.Postulant;
import pe.edu.upc.suscriptionservice.entity.Subscription;
import pe.edu.upc.suscriptionservice.repository.EmployerRepository;
import pe.edu.upc.suscriptionservice.repository.PostulantRepository;
import pe.edu.upc.suscriptionservice.repository.SubscriptionRepository;
import pe.edu.upc.suscriptionservice.service.*;

import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class SubscriptionServiceMockTest {
    @Mock
    EmployerRepository employerRepository;
    @Mock
    PostulantRepository postulantRepository;
    @Mock
    SubscriptionRepository subscriptionRepository;

    private EmployerService employerService;
    private PostulantService postulantService;
    private SubscriptionService subscriptionService;
    @BeforeEach
    public void setup() {
        employerService = new EmployerServiceImplementation(employerRepository);
        postulantService = new PostulantServiceImplementation(postulantRepository);
        subscriptionService = new SubscriptionServiceImplementation(subscriptionRepository);

        Employer employer = Employer.builder()
                .firstName("Djalma")
                .lastName("Dioses")
                .dni("123456")
                .email("dioses@gmail.com")
                .numberPhone("9924234232")
                .password("djalma")
                .build();

        Postulant postulant = Postulant.builder()
                .firstName("Diego")
                .lastName("Emirio")
                .email("diego@gmail.com")
                .password("deigo")
                .number("Djalma")
                .birthday(new Date(System.currentTimeMillis()))
                .civilStatus("Soletro")
                .document("6542423")
                .build();

        Subscription subscription = Subscription.builder()
                .name("Silver")
                .description("Una subscription con 5 postulaciones como max almes")
                .duration("1")
                .limitPostulations("20")
                .build();

        Mockito.when(employerRepository.findById(1L))
                .thenReturn(Optional.of(employer));
        Mockito.when(employerRepository.save(employer))
                .thenReturn(employer);

        Mockito.when(subscriptionRepository.findById(1L))
                .thenReturn(Optional.of(subscription));
        Mockito.when(subscriptionRepository.save(subscription))
                .thenReturn(subscription);

        Mockito.when(postulantRepository.findById(1L))
                .thenReturn(Optional.of(postulant));
        Mockito.when(postulantRepository.save(postulant))
                .thenReturn(postulant);
    }
    @Test
    public void whenValidateGetID_ThenReturnEntity() {

        Subscription foundSubscription = subscriptionService.getSubscription(1L);
        Postulant foundPostulant = postulantService.getPostulant(1L);
        Employer foundEmployer = employerService.getEmployer(1L);

        Assertions.assertThat(foundSubscription.getName()).isEqualTo("Silver");
        Assertions.assertThat(foundPostulant.getFirstName()).isEqualTo("Diego");
        Assertions.assertThat(foundEmployer.getFirstName()).isEqualTo("Djalma");
        //System.out.println(foundCompany.toString());
        //System.out.println(foundSector.toString());
    }
}
