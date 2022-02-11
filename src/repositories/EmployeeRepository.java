package repositories;

import database.DataBaseManager;
import modelsDAO.*;
import modelsDTO.DepartmentDto;
import modelsDTO.EmployeeDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {


    @Override
    public void save(Employee employee) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.pracownik(imie, nazwisko, premia, pensja, id_szef, id_dzial_firmy, id_stanowisko) VALUES(?,?,?,?,?,?,?)");
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setInt(3, employee.getBonus());
        statement.setInt(4, employee.getSalary());
        statement.setInt(5, employee.getEmployeeBoss().getId());
        statement.setInt(6, employee.getEmployeeDepartment().getId());
        statement.setInt(7, employee.getEmployeeJobPosition().getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.pracownik WHERE id_pracownik = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void update(Employee employee) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.pracownik SET imie = ?, nazwisko = ?, premia = ?, pensja = ? WHERE id_pracownik = ?");
        statement.setString(1, employee.getFirstName());
        statement.setString(2, employee.getLastName());
        statement.setInt(3, employee.getBonus());
        statement.setInt(4, employee.getSalary());
        statement.setInt(5, employee.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public Employee getObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_pracownik, id_stanowisko, id_dzial_firmy, imie, nazwisko, premia, pensja,id_szef FROM biuro.pracownik WHERE id_pracownik = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employee employee = new Employee();
        return employee;
    }

    public EmployeeDto getDtoObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_pracownik, imie, nazwisko, premia, pensja FROM biuro.pracownik WHERE id_pracownik = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        EmployeeDto employee = null;
        while (resultSet.next()) {
            employee = new EmployeeDto(resultSet.getInt("id_pracownik"), resultSet.getString("imie"), resultSet.getString("nazwisko"), resultSet.getInt("premia"), resultSet.getInt("pensja"));
        }
        statement.close();
        return employee;
    }

    @Override
    public List<Employee> getListOfObjects() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("select * from pracownicy");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt("id_pracownik"), resultSet.getString("pracownik_imie"), resultSet.getString("pracownik_nazwisko"), resultSet.getInt("premia"), resultSet.getInt("pensja"));
            employee.setEmployeeBoss(new EmployeeDto(resultSet.getString("szef_imie"), resultSet.getString("szef_nazwisko")));
            employee.setEmployeeJobPosition(new JobPosition(resultSet.getString("stanowisko")));
            employee.setEmployeeDepartment(new DepartmentDto(resultSet.getString("dzial_firmy")));
            employees.add(employee);
        }
        statement.close();
        return employees;

    }

    public List<Employee> getListOfSellers() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("select * from pracownicy where dzial_firmy = 'Sprzedaz'");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt("id_pracownik"), resultSet.getString("pracownik_imie"), resultSet.getString("pracownik_nazwisko"), resultSet.getInt("premia"), resultSet.getInt("pensja"));
            employee.setEmployeeBoss(new EmployeeDto(resultSet.getString("szef_imie"), resultSet.getString("szef_nazwisko")));
            employee.setEmployeeJobPosition(new JobPosition(resultSet.getString("stanowisko")));
            employee.setEmployeeDepartment(new DepartmentDto(resultSet.getString("dzial_firmy")));
            employees.add(employee);
        }
        statement.close();
        return employees;
    }
}
