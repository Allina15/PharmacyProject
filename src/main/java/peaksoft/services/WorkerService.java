package peaksoft.services;

import peaksoft.model.Worker;

import java.util.List;

public interface WorkerService{
    Worker save(long pharmacyId, Worker worker);
    String delete(long workerId);
    Worker getById(long workerId);
    List<Worker> getAll();
    void update(long workerId, Worker newWorker);
    List<Worker>getAllSalaryBySort(String ascOrDesc);
}
