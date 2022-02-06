package modelsDAO;

public class Department {
    private int id;
    private String name;
    private int maxNumberOfEmployees;
    private int minNumberOfEmployees;
    private Employee departmentManager;
    private Branch departmentBranch;

    public Department() {
    }

    public Department(String name, int maxNumberOfEmployees, int minNumberOfEmployees, Employee departmentManager, Branch departmentBranch) {
        this.name = name;
        this.maxNumberOfEmployees = maxNumberOfEmployees;
        this.minNumberOfEmployees = minNumberOfEmployees;
        this.departmentManager = departmentManager;
        this.departmentBranch = departmentBranch;
    }

    public Department(int id, String name, int maxNumberOfEmployees, int minNumberOfEmployees, Employee departmentManager, Branch departmentBranch) {
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
