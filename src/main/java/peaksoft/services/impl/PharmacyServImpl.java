package peaksoft.services.impl;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.model.Medicine;
import peaksoft.model.Pharmacy;
import peaksoft.repositories.MedicineRepo;
import peaksoft.repositories.PharmacyRepo;
import peaksoft.services.PharmacyService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class PharmacyServImpl implements PharmacyService {

    @Autowired
    private PharmacyRepo pharmacyRepo;

    @Autowired
    private MedicineRepo medicineRepo;

    @Override
    public Pharmacy save(Pharmacy pharmacy) {
        return pharmacyRepo.save(pharmacy);
    }

    @Override
    public String delete(long pharmacyId) {
    pharmacyRepo.deleteById(pharmacyId);
    return "Successfully";
    }

    @Override
    public Pharmacy getById(long pharmacyId) {
        return pharmacyRepo.findById(pharmacyId).orElseThrow(()->new NoSuchElementException("not found"));
    }

    @Override
    public List<Pharmacy> getAll() {
        return pharmacyRepo.findAll();
    }

    @Override
    public void update(long pharmacyId, Pharmacy newPharmacy) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(()->new NoSuchElementException("not found"));
        pharmacy.setName(newPharmacy.getName());
        pharmacy.setAddress(newPharmacy.getAddress());
        pharmacyRepo.save(pharmacy);
    }

    @Override
    public List<Medicine> getAllMedicinesByPharmacyId(long pharmacyId) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(()->new NoSuchElementException("not found"));
        return pharmacy.getMedicines();
    }
}
