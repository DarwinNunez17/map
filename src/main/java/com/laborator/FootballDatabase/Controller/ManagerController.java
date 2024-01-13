package com.laborator.FootballDatabase.Controller;

import com.laborator.FootballDatabase.Domain.Manager;
import com.laborator.FootballDatabase.Services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Component
@RequestMapping("/managers")
public class ManagerController {
    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping
    public List<Manager> getAllManagers() {
        return managerService.getAllManagers();
    }

    @GetMapping("/{managerId}")
    public Optional<Manager> getManagerById(@PathVariable int managerId) {
        return managerService.getManagerById(managerId);
    }

    @PostMapping
    public void addManager(@RequestBody Manager manager) {
        managerService.addManager(manager);
    }

    @PutMapping("/{managerId}")
    public void updateManager(@PathVariable int managerId, @RequestBody Manager updatedManager) {
        managerService.updateManager(managerId, updatedManager);
    }

    @DeleteMapping("/{managerId}")
    public void deleteManager(@PathVariable int managerId) {
        managerService.deleteManager(managerId);
    }
}
