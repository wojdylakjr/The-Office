package modelsFx;

import javafx.beans.property.*;

public class EmployeeFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty bonus = new SimpleStringProperty();
    private StringProperty salary = new SimpleStringProperty();
    private ObjectProperty<EmployeeFx> employeeBoss = new SimpleObjectProperty<>();
    private ObjectProperty<JobPositionFx> employeeJobPosition = new SimpleObjectProperty<>();
    private ObjectProperty<DepartmentFx> employeeDepartment = new SimpleObjectProperty<>();

    public EmployeeFx() {
    }

    public EmployeeFx(String firstName, String lastName) {
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getBonus() {
        return Integer.parseInt(bonus.get());
    }

    public StringProperty bonusProperty() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus.set(String.valueOf(bonus));
    }

    public int getSalary() {
        return Integer.parseInt(salary.get());
    }

    public StringProperty salaryProperty() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary.set(String.valueOf(salary));
    }

    public EmployeeFx getEmployeeBoss() {
        return employeeBoss.get();
    }

    public ObjectProperty<EmployeeFx> employeeBossProperty() {
        return employeeBoss;
    }

    public void setEmployeeBoss(EmployeeFx employeeBoss) {
        this.employeeBoss.set(employeeBoss);
    }

    public JobPositionFx getEmployeeJobPosition() {
        return employeeJobPosition.get();
    }

    public ObjectProperty<JobPositionFx> employeeJobPositionProperty() {
        return employeeJobPosition;
    }

    public void setEmployeeJobPosition(JobPositionFx employeeJobPosition) {
        this.employeeJobPosition.set(employeeJobPosition);
    }

    public DepartmentFx getEmployeeDepartment() {
        return employeeDepartment.get();
    }

    public ObjectProperty<DepartmentFx> employeeDepartmentProperty() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(DepartmentFx employeeDepartment) {
        this.employeeDepartment.set(employeeDepartment);
    }

    @Override
    public String toString() {
        if (this.firstName.get() != null) {
            return this.firstName.getValue() + " " + this.lastName.getValue();
        } else {
            return "-";
        }

    }
}
