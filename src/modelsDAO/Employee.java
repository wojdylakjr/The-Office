package modelsDAO;

import modelsDTO.DepartmentDto;
import modelsDTO.EmployeeDto;
import services.DepartmentService;
import services.EmployeeService;
import services.JobPositionService;

import java.sql.SQLException;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int bonus;
    private int salary;
    private EmployeeDto employeeBoss;
    private JobPosition employeeJobPosition;
    private DepartmentDto employeeDepartment;

    public Employee() {
    }

    public Employee(int id, String firstName, String lastName, int bonus, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bonus = bonus;
        this.salary = salary;
    }

    public Employee(int id, String firstName, String lastName, int bonus, int salary, EmployeeDto employeeBoss, JobPosition employeeJobPosition, DepartmentDto employeeDepartment) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bonus = bonus;
        this.salary = salary;
        this.employeeBoss = employeeBoss;
        this.employeeJobPosition = employeeJobPosition;
        this.employeeDepartment = employeeDepartment;
    }

    public Employee(String firstName, String lastName, int bonus, int salary, EmployeeDto employeeBoss, JobPosition employeeJobPosition, DepartmentDto employeeDepartment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bonus = bonus;
        this.salary = salary;
        this.employeeBoss = employeeBoss;
        this.employeeJobPosition = employeeJobPosition;
        this.employeeDepartment = employeeDepartment;
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

    public EmployeeDto getEmployeeBoss() {
        return employeeBoss;
    }

    public void setEmployeeBoss(EmployeeDto employeeBoss) {
        this.employeeBoss = employeeBoss;
    }

    public JobPosition getEmployeeJobPosition() {
        return employeeJobPosition;
    }

    public void setEmployeeJobPosition(JobPosition employeeJobPosition) {
        this.employeeJobPosition = employeeJobPosition;
    }

    public DepartmentDto getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(DepartmentDto employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    @Override
    public String toString() {
        if (employeeBoss != null) {
            return "Employee{" +
                    "id=" + id +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", bonus=" + bonus +
                    ", salary=" + salary +
                    ", employeeBoss=" + employeeBoss.getId() +
                    ", employeeJobPosition=" + employeeJobPosition.getId() +
                    ", employeeDepartment=" + employeeDepartment.getId() +
                    '}';
        } else return "Blad";
    }
}