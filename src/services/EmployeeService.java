package services;

import converters.DepartmentConverter;
import converters.EmployeeConverter;
import converters.JobPositionConverter;
import modelsDTO.EmployeeDto;
import modelsFx.DepartmentFx;
import modelsFx.EmployeeFx;
import modelsFx.JobPositionFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.Department;
import modelsDAO.Employee;
import modelsDAO.JobPosition;
import repositories.DepartmentRepository;
import repositories.EmployeeRepository;
import repositories.JobPositionRepository;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private JobPositionRepository jobPositionRepository = new JobPositionRepository();
    private DepartmentRepository departmentRepository = new DepartmentRepository();
    private ObjectProperty<EmployeeFx> employeeFxObjectProperty = new SimpleObjectProperty<>(new EmployeeFx());
    private ObjectProperty<EmployeeFx> employeeFxObjectPropertyUpdate = new SimpleObjectProperty<>(new EmployeeFx());
    private ObservableList<EmployeeFx> employeeFxObservableList = FXCollections.observableArrayList();
    private ObservableList<JobPositionFx> jobPositionFxObservableList = FXCollections.observableArrayList();
    private ObservableList<DepartmentFx> departmentFxObservableList = FXCollections.observableArrayList();
    private ObservableList<EmployeeFx> bossFxObservableList = FXCollections.observableArrayList();

    //automatyczne getery i setery


    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public JobPositionRepository getJobPositionRepository() {
        return jobPositionRepository;
    }

    public void setJobPositionRepository(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    public DepartmentRepository getDepartmentRepository() {
        return departmentRepository;
    }

    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public EmployeeFx getEmployeeFxObjectProperty() {
        return employeeFxObjectProperty.get();
    }

    public ObjectProperty<EmployeeFx> employeeFxObjectPropertyProperty() {
        return employeeFxObjectProperty;
    }

    public void setEmployeeFxObjectProperty(EmployeeFx employeeFxObjectProperty) {
        this.employeeFxObjectProperty.set(employeeFxObjectProperty);
    }

    public EmployeeFx getEmployeeFxObjectPropertyUpdate() {
        return employeeFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<EmployeeFx> employeeFxObjectPropertyUpdateProperty() {
        return employeeFxObjectPropertyUpdate;
    }

    public void setEmployeeFxObjectPropertyUpdate(EmployeeFx employeeFxObjectPropertyUpdate) {
        this.employeeFxObjectPropertyUpdate.set(employeeFxObjectPropertyUpdate);
    }

    public ObservableList<EmployeeFx> getEmployeeFxObservableList() {
        return employeeFxObservableList;
    }

    public void setEmployeeFxObservableList(ObservableList<EmployeeFx> employeeFxObservableList) {
        this.employeeFxObservableList = employeeFxObservableList;
    }

    public ObservableList<JobPositionFx> getJobPositionFxObservableList() {
        return jobPositionFxObservableList;
    }

    public void setJobPositionFxObservableList(ObservableList<JobPositionFx> jobPositionFxObservableList) {
        this.jobPositionFxObservableList = jobPositionFxObservableList;
    }

    public ObservableList<DepartmentFx> getDepartmentFxObservableList() {
        return departmentFxObservableList;
    }

    public void setDepartmentFxObservableList(ObservableList<DepartmentFx> departmentFxObservableList) {

        this.departmentFxObservableList = departmentFxObservableList;
    }

    public ObservableList<EmployeeFx> getBossFxObservableList() {
        return bossFxObservableList;
    }

    public void setBossFxObservableList(ObservableList<EmployeeFx> bossFxObservableList) {
        this.bossFxObservableList = bossFxObservableList;
    }

    //CRUD
    public void saveEmployeeInDatabase() throws SQLException {
        Employee employee = EmployeeConverter.convertToEmployee(this.getEmployeeFxObjectProperty());
        employeeRepository.save(employee);
    }

    public void listEmployees() throws SQLException {
        this.initJobPositionList();
        this.initDepartmentList();
        this.initBossList();
        List<Employee> employees = employeeRepository.getListOfObjects();
        this.employeeFxObservableList.clear();
        for (Employee employee : employees) {
            this.employeeFxObservableList.add(EmployeeConverter.convertToEmployeeFx(employee));
        }
    }


    private void initJobPositionList() throws SQLException {
        List<JobPosition> jobPositions = this.jobPositionRepository.getListOfObjects();
        this.jobPositionFxObservableList.clear();
        for (JobPosition jobPosition : jobPositions) {
            this.jobPositionFxObservableList.add(JobPositionConverter.convertToJobPositionFx(jobPosition));
        }
    }

    private void initDepartmentList() throws SQLException {
        List<Department> departments = this.departmentRepository.getListOfObjects();
        this.departmentFxObservableList.clear();
        for (Department department : departments) {
            this.departmentFxObservableList.add(DepartmentConverter.convertToDepartmentFx(department));
        }
    }

    private void initBossList() throws SQLException {
        List<Employee> bosses = this.employeeRepository.getListOfObjects();
        this.bossFxObservableList.clear();
        for (Employee employee : bosses) {
            this.bossFxObservableList.add(EmployeeConverter.convertToEmployeeFx(employee));
        }
    }

    public void updateEmployeeInDatabase() throws SQLException {
        Employee employee = EmployeeConverter.convertToEmployeeWithId(this.getEmployeeFxObjectPropertyUpdate());
        employeeRepository.update(employee);
    }

    public void deleteEmployeeInDatabase() throws SQLException {
        employeeRepository.delete(this.getEmployeeFxObjectPropertyUpdate().getId());
    }

    public Employee getEmployeeById(int id) throws SQLException {
        return employeeRepository.getObject(id);
    }

    public EmployeeDto getEmployeeDtoById(int id) throws SQLException {
        return employeeRepository.getDtoObject(id);
    }
}
