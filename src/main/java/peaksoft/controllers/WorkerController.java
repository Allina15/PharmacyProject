package peaksoft.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Worker;
import peaksoft.services.WorkerService;

import java.util.List;

@RestController
@RequestMapping("/workers")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @GetMapping
    public List<Worker> getAll(){
        return workerService.getAll();
    }

    @PostMapping("/create/{pharmacyId}")
    public Worker save(@PathVariable long pharmacyId, @RequestBody Worker worker){
        return workerService.save(pharmacyId, worker);
    }

    @DeleteMapping("/{Id}")
    public String delete(@PathVariable long Id){
        return workerService.delete(Id);
    }

    @PutMapping("/update/{Id}")
    public void update(@PathVariable long Id, @RequestBody Worker worker){
        workerService.update(Id,worker);
    }

    @GetMapping("/{Id}")
    public Worker getById(@PathVariable long Id){
        return workerService.getById(Id);
    }

    @GetMapping("/salary")
    public List<Worker> getAllSalaryBySort(@RequestParam(name = "sort", defaultValue = "ASC") String sortDirection, Model model) {
        List<Worker> workers = workerService.getAllSalaryBySort(sortDirection);
        model.addAttribute("workers", workers);
        return workers;
    }
}
