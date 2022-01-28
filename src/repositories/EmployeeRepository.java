package repositories;

import database.DataBaseManager;
import models.*;

import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    public Employee getObject(int id) {
        return null;
    }

    @Override
    public List<Employee> getListOfObjects() throws SQLException {
        System.out.println("Operacja w employee repository");
        ArrayList<Employee> employees = new ArrayList<>();
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_produkt, produkt.nazwa AS \"produkt\", cena, kategoria.nazwa as \"kategoria\" FROM biuro.produkt\n" +
//                "JOIN biuro.kategoria ON produkt.id_kategoria = kategoria.id_kategoria");
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            Employee employee = new Employee();
//            employee.getEmployeeCategory().setCategoryName(resultSet.getString("kategoria"));
//            System.out.println(resultSet.getInt("id_produkt"));
//            System.out.println(resultSet.getString("produkt"));
//            System.out.println(resultSet.getInt("cena"));
//            System.out.println(resultSet.getString("kategoria"));
//
//            employee.setId(resultSet.getInt("id_produkt"));
//            employee.setName(resultSet.getString("produkt"));
//            employee.setPrice(resultSet.getInt("cena"));
//            employee.getEmployeeCategory().setCategoryName(resultSet.getString("kategoria"));
//            employees.add(employee);
//        }
//        statement.close();
        return employees;

    }
}
