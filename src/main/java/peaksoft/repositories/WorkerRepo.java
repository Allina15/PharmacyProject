package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import peaksoft.model.Worker;

public interface WorkerRepo extends JpaRepository<Worker,Long> {
}
