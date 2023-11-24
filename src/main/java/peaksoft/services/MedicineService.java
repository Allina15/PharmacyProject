package peaksoft.services;

import peaksoft.model.Medicine;
import peaksoft.model.Pharmacy;

import java.util.List;

public interface MedicineService {

    Medicine save(long pharmacyId, Medicine medicine);
    String delete(long medicineId);
    Medicine getById(long medicineId);
    List<Medicine> getAll();
    void update(long medicineId, Medicine newMedicine);
    List<Medicine> getAllSortedByPrice(String ascOrDesc);
}
