package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.nio.file.LinkOption;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "pharmacies")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharm_gen" )
    @SequenceGenerator(name = "pharm_gen",sequenceName = "pharm_seq",allocationSize = 1)
    private long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "pharmacy")
    private List<Worker> workers;
    @ManyToMany
    @JoinTable(
            name = "pharmacy_medicine",
            joinColumns = @JoinColumn(name = "pharmacy_id"),
            inverseJoinColumns = @JoinColumn(name = "medicine_id"))
    private List<Medicine>medicines;

    public Pharmacy(String name, String address, List<Medicine> medicines) {
        this.name = name;
        this.address = address;
        this.medicines = medicines;
    }
}
