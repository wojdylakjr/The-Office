package modelsDTO;

import modelsDAO.Department;
import modelsDAO.JobPosition;

public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private int bonus;
    private int salary;

    public EmployeeDto(int id, String firstName, String lastName, int bonus, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bonus = bonus;
        this.salary = salary;
    }

    public EmployeeDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBonus() {
        return bonus;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bonus=" + bonus +
                ", salary=" + salary +
                '}';
    }
}
