package services;

import converters.BranchConverter;
import converters.DepartmentConverter;
import converters.EmployeeConverter;
import modelsDTO.DepartmentDto;
import modelsFx.BranchFx;
import modelsFx.DepartmentFx;
import modelsFx.EmployeeFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.Branch;
import modelsDAO.Department;
import modelsDAO.Employee;
import repositories.BranchRepository;
import repositories.DepartmentRepository;
import repositories.EmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    private DepartmentRepository departmentRepository = new DepartmentRepository();
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private BranchRepository branchRepository = new BranchRepository();
    private ObjectProperty<DepartmentFx> departmentFxObjectProperty = new SimpleObjectProperty<>(new DepartmentFx());
    private ObjectProperty<DepartmentFx> departmentFxObjectPropertyUpdate = new SimpleObjectProperty<>(new DepartmentFx());
    private ObservableList<DepartmentFx> departmentFxObservableList = FXCollections.observableArrayList();
    private ObservableList<EmployeeFx> employeeFxObservableList = FXCollections.observableArrayList();
    private ObservableList<BranchFx> branchFxObservableList = FXCollections.observableArrayList();


    //automatyczne getery i setery


    public DepartmentRepository getDepartmentRepository() {
        return departmentRepository;
    }

    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public BranchRepository getBranchRepository() {
        return branchRepository;
    }

    public void setBranchRepository(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public DepartmentFx getDepartmentFxObjectProperty() {
        return departmentFxObjectProperty.get();
    }

    public ObjectProperty<DepartmentFx> departmentFxObjectPropertyProperty() {
        return departmentFxObjectProperty;
    }

    public void setDepartmentFxObjectProperty(DepartmentFx departmentFxObjectProperty) {
        this.departmentFxObjectProperty.set(departmentFxObjectProperty);
    }

    public DepartmentFx getDepartmentFxObjectPropertyUpdate() {
        return departmentFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<DepartmentFx> departmentFxObjectPropertyUpdateProperty() {
        return departmentFxObjectPropertyUpdate;
    }

    public void setDepartmentFxObjectPropertyUpdate(DepartmentFx departmentFxObjectPropertyUpdate) {
        this.departmentFxObjectPropertyUpdate.set(departmentFxObjectPropertyUpdate);
    }

    public ObservableList<DepartmentFx> getDepartmentFxObservableList() {
        return departmentFxObservableList;
    }

    public void setDepartmentFxObservableList(ObservableList<DepartmentFx> departmentFxObservableList) {
        this.departmentFxObservableList = departmentFxObservableList;
    }

    public ObservableList<EmployeeFx> getEmployeeFxObservableList() {
        return employeeFxObservableList;
    }

    public void setEmployeeFxObservableList(ObservableList<EmployeeFx> employeeFxObservableList) {
        this.employeeFxObservableList = employeeFxObservableList;
    }

    public ObservableList<BranchFx> getBranchFxObservableList() {
        return branchFxObservableList;
    }

    public void setBranchFxObservableList(ObservableList<BranchFx> branchFxObservableList) {
        this.branchFxObservableList = branchFxObservableList;
    }

    //CRUD
    public void saveDepartmentInDatabase() throws SQLException {
        System.out.println(this.getDepartmentFxObjectProperty());
        Department department = DepartmentConverter.convertToDepartment(this.getDepartmentFxObjectProperty());
        departmentRepository.save(department);
    }

    public void listDepartments() throws SQLException {
        this.initBranchesList();
        this.initEmployeesList();
        List<Department> departments = departmentRepository.getListOfObjects();
        this.departmentFxObservableList.clear();
        for (Department department : departments) {
            this.departmentFxObservableList.add(DepartmentConverter.convertToDepartmentFx(department));
        }
    }


    private void initBranchesList() throws SQLException {
        List<Branch> branches = this.branchRepository.getListOfObjects();
        this.branchFxObservableList.clear();
        for (Branch branch : branches) {
//            System.out.println(category);
            this.branchFxObservableList.add(BranchConverter.convertToBranchFx(branch));
        }
//        System.out.println(this.categoryFxObservableList.toString());
    }
    private void initEmployeesList() throws SQLException {
        List<Employee> employees = this.employeeRepository.getListOfObjects();
        this.employeeFxObservableList.clear();
        for (Employee employee : employees) {
//            System.out.println(category);
            this.employeeFxObservableList.add(EmployeeConverter.convertToEmployeeFx(employee));
        }
//        System.out.println(this.categoryFxObservableList.toString());
    }


    public void updateDepartmentInDatabase() throws SQLException {
        System.out.println(this.getDepartmentFxObjectPropertyUpdate());
        Department department = DepartmentConverter.convertToDepartmentWithId(this.getDepartmentFxObjectPropertyUpdate());
        System.out.println(department);
        departmentRepository.update(department);
    }

    public void deleteDepartmentInDatabase() throws SQLException {
        departmentRepository.delete(this.getDepartmentFxObjectPropertyUpdate().getId());
    }

    public Department getDepartmentById(int id) throws SQLException{
        return departmentRepository.getObject(id);
    }

    public DepartmentDto getDepartmentDtoById(int id) throws SQLException {
        return departmentRepository.getDtoObject(id);
    }
}
