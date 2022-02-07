package modelsDAO;

import modelsDTO.BranchDto;
import modelsDTO.EmployeeDto;

public class Department {
    private int id;
    private String name;
    private int maxNumberOfEmployees;
    private int minNumberOfEmployees;
    private EmployeeDto departmentManager;
    private BranchDto departmentBranch;

    public Department() {
    }

    public Department(String name, int maxNumberOfEmployees, int minNumberOfEmployees, EmployeeDto departmentManager, BranchDto departmentBranch) {
        this.name = name;
        this.maxNumberOfEmployees = maxNumberOfEmployees;
        this.minNumberOfEmployees = minNumberOfEmployees;
        this.departmentManager = departmentManager;
        this.departmentBranch = departmentBranch;
    }

    public Department(int id, String name, int maxNumberOfEmployees, int minNumberOfEmployees, EmployeeDto departmentManager, BranchDto departmentBranch) {
        this.id = id;
        this.name = name;
        this.maxNumberOfEmployees = maxNumberOfEmployees;
        this.minNumberOfEmployees = minNumberOfEmployees;
        this.departmentManager = departmentManager;
        this.departmentBranch = departmentBranch;
    }

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

    public EmployeeDto getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(EmployeeDto departmentManager) {
        this.departmentManager = departmentManager;
    }

    public BranchDto getDepartmentBranch() {
        return departmentBranch;
    }

    public void setDepartmentBranch(BranchDto departmentBranch) {
        this.departmentBranch = departmentBranch;
    }


//    public void setDepartmentBranchFromDatabase(int departmentBranch) {
//        this.departmentBranch = departmentBranch;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxNumberOfEmployees=" + maxNumberOfEmployees +
                ", minNumberOfEmployees=" + minNumberOfEmployees +
                ", departmentManager=" + departmentManager +
                ", departmentBranch=" + departmentBranch +
                '}';
    }
}
