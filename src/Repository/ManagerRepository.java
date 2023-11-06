package Repository;

import Domain.Manager;

import java.util.ArrayList;
import java.util.List;

public class ManagerRepository {
    private List<Manager> managers = new ArrayList<>();

    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public Manager getManagerByID(int managerID) {
        for (Manager manager : managers) {
            if (manager.getManagerID() == managerID) {
                return manager;
            }
        }
        return null;
    }

    public List<Manager> getAllManagers() {
        return managers;
    }

}
