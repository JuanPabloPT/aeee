package pe.edu.pe.postulation.entity;

import lombok.Data;
import pe.edu.pe.postulation.model.CV;
import pe.edu.pe.postulation.model.Postulant;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="tbl_postulantsCV")
public class PostulantsCV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "postulantCV_id")
    private Long postulantCVId;

    @Transient
    CV cv;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }
}
