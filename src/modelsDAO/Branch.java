package modelsDAO;

import modelsDTO.EmployeeDto;
import services.EmployeeService;

import java.sql.SQLException;

public class Branch {
    private int id;
    private String cityName;
    private EmployeeDto branchDirector;

    public Branch() {
    }

    public Branch(int id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public Branch(String cityName, EmployeeDto branchDirector) {
        this.cityName = cityName;
        this.branchDirector = branchDirector;
    }

    public Branch(int id, String cityName, EmployeeDto branchDirector) {
        this.id = id;
        this.cityName = cityName;
        this.branchDirector = branchDirector;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public EmployeeDto getBranchDirector() {
        return branchDirector;
    }

    public void setBranchDirectorFromDatabase(int branchDirectorId) {
        EmployeeService employeeService = new EmployeeService();
        try {
            this.branchDirector = employeeService.getEmployeeDtoById(branchDirectorId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBranchDirector(EmployeeDto branchDirector) {
        this.branchDirector = branchDirector;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", cityName='" + cityName + '\'' +
                ", branchDirector=" + branchDirector +
                '}';
    }
}
