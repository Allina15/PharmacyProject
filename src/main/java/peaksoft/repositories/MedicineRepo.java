package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Medicine;

public interface MedicineRepo extends JpaRepository<Medicine,Long> {
}
