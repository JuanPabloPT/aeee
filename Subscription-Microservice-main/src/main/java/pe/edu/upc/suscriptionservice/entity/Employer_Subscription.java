package pe.edu.upc.suscriptionservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name = "tbl_employer_subscription")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employer_Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "subscription_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    private Subscription subscription;

    @Temporal(TemporalType.DATE)
    private Date date;
}
