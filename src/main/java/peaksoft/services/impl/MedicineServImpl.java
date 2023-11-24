package peaksoft.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import peaksoft.model.Medicine;
import peaksoft.model.Pharmacy;
import peaksoft.repositories.MedicineRepo;
import peaksoft.repositories.PharmacyRepo;
import peaksoft.services.MedicineService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class MedicineServImpl implements MedicineService {

    @Autowired
    private MedicineRepo medicineRepo;
    @Autowired
    private PharmacyRepo pharmacyRepo;

    @Override
    public Medicine save(long pharmacyId, Medicine medicine) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(EntityNotFoundException::new);
        medicine.setPharmacies(Collections.singletonList(pharmacy));
        List<Medicine> medicines = pharmacy.getMedicines();
        if (medicines == null) {
            medicines = new ArrayList<>();
        }
        medicines.add(medicine);
        pharmacy.setMedicines(medicines);
        medicineRepo.save(medicine);
        return medicine;
    }

    @Override
    public String delete(long medicineId) {
    medicineRepo.deleteById(medicineId);
    return "successfully";
    }

    @Override
    public Medicine getById(long medicineId) {
        return medicineRepo.findById(medicineId).orElseThrow(()->new NoSuchElementException("not found"));
    }

    @Override
    public List<Medicine> getAll() {
        return medicineRepo.findAll();
    }

    @Override
    public void update(long medicineId, Medicine newMedicine) {
        Medicine medicine = medicineRepo.findById(medicineId).orElseThrow(()->new NoSuchElementException("not found"));
        medicine.setName(newMedicine.getName());
        medicine.setPrice(newMedicine.getPrice());
        medicineRepo.save(medicine);
    }

    @Override
    public List<Medicine> getAllSortedByPrice(String ascOrDesc) {
        Sort sort = Sort.by("price").ascending();

        if ("DESC".equalsIgnoreCase(ascOrDesc)) {
            sort = Sort.by("price").descending();
        }
    return medicineRepo.findAll(sort);
    }
}
