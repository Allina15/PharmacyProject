package peaksoft.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Medicine;
import peaksoft.model.Pharmacy;
import peaksoft.services.MedicineService;
import peaksoft.services.PharmacyService;

import java.util.List;

@RestController
@RequestMapping("/pharmacies")
@RequiredArgsConstructor
public class PharmacyController {

    private final PharmacyService pharmacyService;
    private final MedicineService medicineService;


    @GetMapping
    public List<Pharmacy> getAll(){
        return pharmacyService.getAll();
    }

    @PostMapping("/create")
    public Pharmacy save(@RequestBody Pharmacy pharmacy){
        return pharmacyService.save(pharmacy);
    }

    @DeleteMapping("/{pharmacyId}")
    public String delete(@PathVariable long pharmacyId){
        return pharmacyService.delete(pharmacyId);
    }

    @PutMapping("/update/{pharmacyId}")
    public void update(@PathVariable long pharmacyId, @RequestBody Pharmacy pharmacy){
        pharmacyService.update(pharmacyId,pharmacy);
    }

    @GetMapping("/{pharmacyId}")
    public Pharmacy getById(@PathVariable long pharmacyId){
        return pharmacyService.getById(pharmacyId);
    }

    @GetMapping("/{pharmacyId}/medicinesByPharmacy")
    public List<Medicine>getAllMedicinesByPharmacyId(@PathVariable long pharmacyId){
        return pharmacyService.getAllMedicinesByPharmacyId(pharmacyId);
    }
}
