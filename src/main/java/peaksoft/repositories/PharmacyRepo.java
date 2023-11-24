package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Pharmacy;

public interface PharmacyRepo extends JpaRepository<Pharmacy, Long> {
}
