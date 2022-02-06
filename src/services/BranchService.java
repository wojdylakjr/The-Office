package services;

import converters.EmployeeConverter;
import converters.BranchConverter;
import modelsFx.EmployeeFx;
import modelsFx.BranchFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.Employee;
import modelsDAO.Branch;
import repositories.EmployeeRepository;
import repositories.BranchRepository;

import java.sql.SQLException;
import java.util.List;

public class BranchService {
    private BranchRepository branchRepository = new BranchRepository();
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private ObjectProperty<BranchFx> branchFxObjectProperty = new SimpleObjectProperty<>(new BranchFx());
    private ObjectProperty<BranchFx> branchFxObjectPropertyUpdate = new SimpleObjectProperty<>(new BranchFx());
    private ObservableList<BranchFx> branchFxObservableList = FXCollections.observableArrayList();
    private ObservableList<EmployeeFx> employeeFxObservableList = FXCollections.observableArrayList();

    //automatyczne getery i setery


    public BranchRepository getBranchRepository() {
        return branchRepository;
    }

    public void setBranchRepository(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public BranchFx getBranchFxObjectProperty() {
        return branchFxObjectProperty.get();
    }

    public ObjectProperty<BranchFx> branchFxObjectPropertyProperty() {
        return branchFxObjectProperty;
    }

    public void setBranchFxObjectProperty(BranchFx branchFxObjectProperty) {
        this.branchFxObjectProperty.set(branchFxObjectProperty);
    }

    public BranchFx getBranchFxObjectPropertyUpdate() {
        return branchFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<BranchFx> branchFxObjectPropertyUpdateProperty() {
        return branchFxObjectPropertyUpdate;
    }

    public void setBranchFxObjectPropertyUpdate(BranchFx branchFxObjectPropertyUpdate) {
        this.branchFxObjectPropertyUpdate.set(branchFxObjectPropertyUpdate);
    }

    public ObservableList<BranchFx> getBranchFxObservableList() {
        return branchFxObservableList;
    }

    public void setBranchFxObservableList(ObservableList<BranchFx> branchFxObservableList) {
        this.branchFxObservableList = branchFxObservableList;
    }

    public ObservableList<EmployeeFx> getEmployeeFxObservableList() {
        return employeeFxObservableList;
    }

    public void setEmployeeFxObservableList(ObservableList<EmployeeFx> employeeFxObservableList) {
        this.employeeFxObservableList = employeeFxObservableList;
    }

    //CRUD
    public void saveBranchInDatabase() throws SQLException {
        System.out.println(this.getBranchFxObjectProperty());
        Branch branch = BranchConverter.convertToBranch(this.getBranchFxObjectProperty());
        branchRepository.save(branch);
    }

    public void listBranches() throws SQLException {
        this.initEmployeeList();
        List<Branch> branches = branchRepository.getListOfObjects();
        this.branchFxObservableList.clear();
        for (Branch branch : branches) {
            this.branchFxObservableList.add(BranchConverter.convertToBranchFx(branch));
        }
    }

    private void initEmployeeList() throws SQLException {
        List<Employee> employees = employeeRepository.getListOfObjects();
        this.employeeFxObservableList.clear();
        for (Employee employee : employees) {
//            System.out.println(employee);
            this.employeeFxObservableList.add(EmployeeConverter.convertToEmployeeFx(employee));
        }
//        System.out.println(this.employeeFxObservableList.toString());
    }

    public void updateBranchInDatabase() throws SQLException {
        System.out.println(this.getBranchFxObjectPropertyUpdate());
        Branch branch = BranchConverter.convertToBranchWithId(this.getBranchFxObjectPropertyUpdate());
        System.out.println(branch);
        branchRepository.update(branch);
    }

    public void deleteBranchInDatabase() throws SQLException {
        branchRepository.delete(this.getBranchFxObjectPropertyUpdate().getId());
    }

    public Branch getBranchById(int id) throws SQLException{
        return branchRepository.getObject(id);
    }
}
