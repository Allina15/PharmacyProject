package peaksoft.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_gen" )
    @SequenceGenerator(name = "med_gen",sequenceName = "med_seq",allocationSize = 1)
    private long id;
    private String name;
    private int price;
    @JsonIgnore
    @ManyToMany(mappedBy = "medicines")
    private List<Pharmacy>pharmacies;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
}
