package repositories;

import database.DataBaseManager;
import modelsDAO.*;
import modelsDTO.EmployeeDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {


    @Override
    public void save(Employee employee) throws SQLException {
        System.out.println("Operacja w employee repository");
//        System.out.println(employee);
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Produkt(nazwa, cena, id_kategoria) VALUES(?,?,?)");
//        statement.setString(1, employee.getName());
//        statement.setInt(2, employee.getPrice());
//        statement.setInt(3, employee.getEmployeeCategory().getId());
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("Operacja w employee repository");
////        System.out.println("Employee repo, imie: " + employee.getName()+", nazwisko: " + employee.getName() +", id: " + employee.getId() );
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.produkt WHERE id_produkt = ?");
//        statement.setInt(1, id);
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public void update(Employee employee) throws SQLException {
////        System.out.println("Operacja w employee repository");
////        System.out.println("Employee repo, imie: " + employee.getName() + ", nazwisko: " + employee.getName() + ", id: " + employee.getId());
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.produkt SET nazwa = ?, cena = ? WHERE id_produkt = ?");
//        statement.setString(1, employee.getName());
//        statement.setInt(2, employee.getPrice());
//        statement.setInt(3, employee.getId());
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public Employee getObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_pracownik, id_stanowisko, id_dzial_firmy, imie, nazwisko, premia, pensja,id_szef FROM biuro.pracownik WHERE id_pracownik = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        Employee employee = new Employee();
//        while (resultSet.next()) {
//
////            System.out.println(resultSet.getInt("id_produkt"));
////            System.out.println(resultSet.getString("produkt"));
////            System.out.println(resultSet.getInt("cena"));
////            System.out.println(resultSet.getString("kategoria"));
//
//            employee.setId(resultSet.getInt("id_pracownik"));
//            employee.setFirstName(resultSet.getString("imie"));
//            employee.setLastName(resultSet.getString("nazwisko"));
//            employee.setBonus(resultSet.getInt("premia"));
//            employee.setSalary(resultSet.getInt("pensja"));
//            employee.setEmployeeBossID(resultSet.getInt("id_szef"));
//            employee.setEmployeeJobPositionFromDatabase(resultSet.getInt("id_stanowisko"));
//            employee.setEmployeeDepartmentFromDatabase(resultSet.getInt("id_dzial_firmy"));
//            System.out.println("Dzial pracownika: " + employee.getEmployeeDepartment());
//            System.out.println("Stanowisko pracownika: " + employee.getEmployeeJobPosition());
//
//        }
//        statement.close();
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
//        System.out.println("EmployeeDto z repo: " + employee);


        statement.close();
        return employee;
    }

    @Override
    public List<Employee> getListOfObjects() throws SQLException {
        ArrayList<Employee> employees = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_pracownik, id_stanowisko, id_dzial_firmy, imie, nazwisko, premia, pensja,id_szef FROM biuro.pracownik");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Employee employee = new Employee(resultSet.getInt("id_pracownik"), resultSet.getString("imie"),resultSet.getString("nazwisko"),resultSet.getInt("premia"),resultSet.getInt("pensja"));

            employee.setEmployeeBossFromDatabase(resultSet.getInt("id_szef"));
            employee.setEmployeeJobPositionFromDatabase(resultSet.getInt("id_stanowisko"));
            employee.setEmployeeDepartmentFromDatabase(resultSet.getInt("id_dzial_firmy"));

//            System.out.println("Dzial pracownika: " + employee.getEmployeeDepartment());
//            System.out.println("Stanowisko pracownika: " + employee.getEmployeeJobPosition());
            employees.add(employee);

        }
        statement.close();
        return employees;

    }
}
