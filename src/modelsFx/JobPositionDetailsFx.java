package modelsFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JobPositionDetailsFx {
    private StringProperty jobPositionName = new SimpleStringProperty();
    private IntegerProperty averageSalary = new SimpleIntegerProperty();
    private IntegerProperty maxSalary = new SimpleIntegerProperty();
    private IntegerProperty minSalary = new SimpleIntegerProperty();
    private IntegerProperty numberOfEmployees = new SimpleIntegerProperty();
    private IntegerProperty numberOfBonuses = new SimpleIntegerProperty();

    public JobPositionDetailsFx() {
    }

    public JobPositionDetailsFx(String jobPositionName, int averageSalary, int maxSalary, int minSalary, int numberOfEmployees, int numberOfBonuses) {
        this.jobPositionName.setValue(jobPositionName);
        this.averageSalary.set(averageSalary);
        this.maxSalary.set(maxSalary);
        this.minSalary.set(minSalary);
        this.numberOfEmployees.set(numberOfEmployees);
        this.numberOfBonuses.set(numberOfBonuses);
    }

    public String getJobPositionName() {
        return jobPositionName.get();
    }

    public StringProperty jobPositionNameProperty() {
        return jobPositionName;
    }

    public void setJobPositionName(String jobPositionName) {
        this.jobPositionName.set(jobPositionName);
    }

    public int getAverageSalary() {
        return averageSalary.get();
    }

    public IntegerProperty averageSalaryProperty() {
        return averageSalary;
    }

    public void setAverageSalary(int averageSalary) {
        this.averageSalary.set(averageSalary);
    }

    public int getMaxSalary() {
        return maxSalary.get();
    }

    public IntegerProperty maxSalaryProperty() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary.set(maxSalary);
    }

    public int getMinSalary() {
        return minSalary.get();
    }

    public IntegerProperty minSalaryProperty() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary.set(minSalary);
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees.get();
    }

    public IntegerProperty numberOfEmployeesProperty() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees.set(numberOfEmployees);
    }

    public int getNumberOfBonuses() {
        return numberOfBonuses.get();
    }

    public IntegerProperty numberOfBonusesProperty() {
        return numberOfBonuses;
    }

    public void setNumberOfBonuses(int numberOfBonuses) {
        this.numberOfBonuses.set(numberOfBonuses);
    }
}
