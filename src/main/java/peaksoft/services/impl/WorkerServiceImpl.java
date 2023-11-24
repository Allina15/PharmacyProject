package peaksoft.services.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import peaksoft.model.Medicine;
import peaksoft.model.Pharmacy;
import peaksoft.model.Worker;
import peaksoft.repositories.PharmacyRepo;
import peaksoft.repositories.WorkerRepo;
import peaksoft.services.WorkerService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional

public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepo workerRepo;

    @Autowired
    private PharmacyRepo pharmacyRepo;

    @Override
    public Worker save(long pharmacyId, Worker worker) {
        Pharmacy pharmacy = pharmacyRepo.findById(pharmacyId).orElseThrow(EntityNotFoundException::new);
        worker.setPharmacy(pharmacy);
        return worker;
    }

    @Override
    public String delete(long workerId) {
    workerRepo.deleteById(workerId);
    return "Successfully";
    }

    @Override
    public Worker getById(long workerId) {
        return workerRepo.findById(workerId).orElseThrow(()->new NoSuchElementException("not found"));
    }

    @Override
    public List<Worker> getAll() {
        return workerRepo.findAll();
    }

    @Override
    public void update(long workerId, Worker newWorker) {
        Worker worker = workerRepo.findById(workerId).orElseThrow(()->new NoSuchElementException("not found"));
        worker.setName(newWorker.getName());
        worker.setEmail(newWorker.getEmail());
        worker.setAddress(newWorker.getAddress());
        worker.setSalary(newWorker.getSalary());
        worker.setDateOfBirth(newWorker.getDateOfBirth());
        workerRepo.save(worker);
    }

    @Override
    public List<Worker> getAllSalaryBySort(String ascOrDesc) {
        Sort sort = Sort.by("salary").ascending();

        if ("DESC".equalsIgnoreCase(ascOrDesc)) {
            sort = Sort.by("salary").descending();
        }
        return workerRepo.findAll(sort);
    }
}
