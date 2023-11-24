package models;

import java.util.List;

//Doanh Thu
public class Revenue {
    private int id;
    Computer computer;
    Service service;

    public Revenue(int id, Computer computer, Service service) {
        this.id = id;
        this.computer = computer;
        this.service = service;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
