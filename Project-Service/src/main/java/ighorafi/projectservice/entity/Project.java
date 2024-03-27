package ighorafi.projectservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String projectId;
    private String projectLibelle;
    private LocalDate dateDebut;
    private LocalDate dateFin;
}
