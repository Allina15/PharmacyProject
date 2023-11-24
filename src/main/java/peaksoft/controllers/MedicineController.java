package peaksoft.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Medicine;
import peaksoft.services.MedicineService;

import java.util.List;

@RestController
@RequestMapping("/medicines")
@RequiredArgsConstructor

public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping
    public List<Medicine> getAll(){
        return medicineService.getAll();
    }

    @PostMapping("/create/{pharmacyId}")
    public Medicine save(@PathVariable("pharmacyId") long pharmacyId, @RequestBody Medicine medicine){
        return medicineService.save(pharmacyId, medicine);
    }

    @DeleteMapping("/{medicineId}")
    public String delete(@PathVariable long medicineId){
        return medicineService.delete(medicineId);
    }

    @PutMapping("/update/{medicineId}")
    public void update(@PathVariable long medicineId, @RequestBody Medicine medicine){
        medicineService.update(medicineId,medicine);
    }

    @GetMapping("/{medicineId}")
    public Medicine getById(@PathVariable long medicineId){
        return medicineService.getById(medicineId);
    }

    @GetMapping("/sortedByPrice")
    public String getAllSortedByPrice(@RequestParam(name = "sort", defaultValue = "ASC") String sortDirection, Model model) {
        List<Medicine> medicines = medicineService.getAllSortedByPrice(sortDirection);
        return model.addAttribute("medicines", medicines).toString();
    }
}
