package com.laborator.FootballDatabase.Services;

import com.laborator.FootballDatabase.Domain.Manager;
import com.laborator.FootballDatabase.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {
    private final ManagerRepository managerRepository;

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Optional<Manager> getManagerById(int managerId) {
        return managerRepository.findById((long) managerId);
    }

    public void addManager(Manager manager) {
        managerRepository.save(manager);
    }

    public void updateManager(int managerId, Manager updatedManager) {
        if (managerRepository.existsById((long) managerId)) {
            updatedManager.setManagerID(managerId);
            managerRepository.save(updatedManager);
        }
    }

    public void deleteManager(int managerId) {
        managerRepository.deleteById((long) managerId);
    }
}
