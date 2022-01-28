package models;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int bonus;
    private int salary;
    private Employee employeeBoss;
    private JobPosition employeeJobPosition;
    private Department employeeDepartment;

    public Employee() {
        this.employeeBoss = new Employee();
        this.employeeJobPosition = new JobPosition();
        this.employeeDepartment = new Department();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee getEmployeeBoss() {
        return employeeBoss;
    }

    public void setEmployeeBoss(Employee employeeBoss) {
        this.employeeBoss = employeeBoss;
    }

    public JobPosition getEmployeeJobPosition() {
        return employeeJobPosition;
    }

    public void setEmployeeJobPosition(JobPosition employeeJobPosition) {
        this.employeeJobPosition = employeeJobPosition;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}