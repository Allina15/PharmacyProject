package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "workers")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worker_gen" )
    @SequenceGenerator(name = "worker_gen",sequenceName = "worker_seq",allocationSize = 1)
    private long id;
    private String name;
    @Column(unique = true)
    private String email;
    private int salary;
    private String address;
    private String dateOfBirth;
    @ManyToOne
    private Pharmacy pharmacy;

}
