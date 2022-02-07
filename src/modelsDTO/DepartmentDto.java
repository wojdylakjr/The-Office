package modelsDTO;

import modelsDAO.Branch;
import modelsDAO.Employee;

public class DepartmentDto {
    private int id;
    private String name;
    private int maxNumberOfEmployees;
    private int minNumberOfEmployees;

    public DepartmentDto(int id, String name, int maxNumberOfEmployees, int minNumberOfEmployees) {
        this.id = id;
        this.name = name;
        this.maxNumberOfEmployees = maxNumberOfEmployees;
        this.minNumberOfEmployees = minNumberOfEmployees;
    }

    public DepartmentDto(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumberOfEmployees() {
        return maxNumberOfEmployees;
    }

    public int getMinNumberOfEmployees() {
        return minNumberOfEmployees;
    }
}
