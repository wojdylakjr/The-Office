package models;

public class Department {
    private int id;
    private String name;
    private int maxNumberOfEmployees;
    private int minNumberOfEmployees;
    private Employee departmentManager;
    private Branch departmentBranch;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxNumberOfEmployees() {
        return maxNumberOfEmployees;
    }

    public void setMaxNumberOfEmployees(int maxNumberOfEmployees) {
        this.maxNumberOfEmployees = maxNumberOfEmployees;
    }

    public int getMinNumberOfEmployees() {
        return minNumberOfEmployees;
    }

    public void setMinNumberOfEmployees(int minNumberOfEmployees) {
        this.minNumberOfEmployees = minNumberOfEmployees;
    }

    public Employee getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }

    public Branch getDepartmentBranch() {
        return departmentBranch;
    }

    public void setDepartmentBranch(Branch departmentBranch) {
        this.departmentBranch = departmentBranch;
    }
}
