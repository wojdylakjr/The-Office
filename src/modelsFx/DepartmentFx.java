package modelsFx;

import javafx.beans.property.*;

public class DepartmentFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty maxNumberOfEmployees = new SimpleStringProperty();
    private StringProperty minNumberOfEmployees = new SimpleStringProperty();
    private ObjectProperty<EmployeeFx> departmentManager = new SimpleObjectProperty<>();
    private ObjectProperty<BranchFx> departmentBranch = new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getMaxNumberOfEmployees() {
        System.out.println(maxNumberOfEmployees.getValue());
        return Integer.parseInt(maxNumberOfEmployees.get());
    }

    public StringProperty maxNumberOfEmployeesProperty() {
        return maxNumberOfEmployees;
    }

    public void setMaxNumberOfEmployees(int maxNumberOfEmployees) {
        this.maxNumberOfEmployees.set(String.valueOf(maxNumberOfEmployees));
    }

    public int getMinNumberOfEmployees() {
        return Integer.parseInt(minNumberOfEmployees.get());
    }

    public StringProperty minNumberOfEmployeesProperty() {
        return minNumberOfEmployees;
    }

    public void setMinNumberOfEmployees(int minNumberOfEmployees) {
        this.minNumberOfEmployees.set(String.valueOf(minNumberOfEmployees));
    }

    public EmployeeFx getDepartmentManager() {
        return departmentManager.get();
    }

    public ObjectProperty<EmployeeFx> departmentManagerProperty() {
        return departmentManager;
    }

    public void setDepartmentManager(EmployeeFx departmentManager) {
        this.departmentManager.set(departmentManager);
    }

    public BranchFx getDepartmentBranch() {
        return departmentBranch.get();
    }

    public ObjectProperty<BranchFx> departmentBranchProperty() {
        return departmentBranch;
    }

    public void setDepartmentBranch(BranchFx departmentBranch) {
        this.departmentBranch.set(departmentBranch);
    }

    @Override
    public String toString() {
        if (departmentBranch.get() != null) {
            return name.getValue() + " [" + departmentBranch.get() + "]";
        } else {
            return name.getValue();
        }

    }
}
