package pe.edu.upc.suscriptionservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tbl_postulant")
@Data
@Builder
@AllArgsConstructor@NoArgsConstructor
public class Postulant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "No puede estar vacio!")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "No puede estar vacio!")
    @Column(name = "last_name")
    private String lastName;

    @Size(message = "No puede estar vacio!")
    private String number;

    @NotEmpty(message = "No puede estar vacio!")
    private String password;

    @NotEmpty(message = "No puede estar vacio!")
    @Email
    private String email;

    @NotEmpty(message = "No puede estar vacio!")
    private String document;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @NotEmpty(message = "No puede estar vacio!")
    @Column(name = "civil_status")
    private String civilStatus;
}
