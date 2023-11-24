package peaksoft.services;

import peaksoft.model.Medicine;
import peaksoft.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    Pharmacy save(Pharmacy pharmacy);
    String delete(long pharmacyId);
    Pharmacy getById(long pharmacyId);
    List<Pharmacy> getAll();
    void update(long pharmacyId, Pharmacy newPharmacy);
    List<Medicine> getAllMedicinesByPharmacyId(long pharmacyId);

}
