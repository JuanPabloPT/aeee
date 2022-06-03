package pe.edu.pe.postulation.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import pe.edu.pe.postulation.model.JobOffer;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tbl_postulations")
public class Postulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_postulation")
    private String numberPostulation;

    @Column(name = "jobOffer_id")
    private Long jobOfferId;

    @Transient
    private JobOffer jobOffer;

    private String state;

    @Valid
    @JsonIgnoreProperties({ "hibernateLazyInitializar", "handler"})
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="postulants")
    private List<PostulantsCV> list;

    public Postulation() {list = new ArrayList<>();}

}
