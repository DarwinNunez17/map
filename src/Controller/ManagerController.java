package Controller;

import Domain.Manager;
import Repository.ManagerRepository;

import java.util.List;

public class ManagerController {
    private ManagerRepository managerRepo;

    public ManagerController() {
        this.managerRepo = new ManagerRepository();
    }

    public void addManager(int managerID, String name, String nationality, int teamID) {
        Manager manager = new Manager(managerID, name, nationality, teamID);
        managerRepo.addManager(manager);
    }

    public Manager getManagerByID(int managerID) {
        return managerRepo.getManagerByID(managerID);
    }

    public List<Manager> getAllManagers() {
        return managerRepo.getAllManagers();
    }
}