package repositories;

import database.DataBaseManager;
import modelsDAO.*;
import modelsDTO.DepartmentDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements Repository<Department> {


    @Override
    public void save(Department department) throws SQLException {
        System.out.println("Operacja w department repository");
//        System.out.println(department);
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Produkt(nazwa, cena, id_kategoria) VALUES(?,?,?)");
//        statement.setString(1, department.getName());
//        statement.setInt(2, department.getPrice());
//        statement.setInt(3, department.getDepartmentCategory().getId());
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("Operacja w department repository");
//////        System.out.println("Department repo, imie: " + department.getName()+", nazwisko: " + department.getName() +", id: " + department.getId() );
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.produkt WHERE id_produkt = ?");
//        statement.setInt(1, id);
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public void update(Department department) throws SQLException {
        System.out.println("Operacja w department repository");
//        System.out.println("Department repo, imie: " + department.getName() + ", nazwisko: " + department.getName() + ", id: " + department.getId());
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.produkt SET nazwa = ?, cena = ? WHERE id_produkt = ?");
//        statement.setString(1, department.getName());
//        statement.setInt(2, department.getPrice());
//        statement.setInt(3, department.getId());
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public Department getObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_dzial_firmy, id_kierownik_dzial, id_oddzial, nazwa, max_liczba_pracownikow, min_liczba_pracownikow FROM biuro.dzial_firmy WHERE id_dzial_firmy = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        Department department = new Department();
        while (resultSet.next()) {
            department.setId(resultSet.getInt("id_dzial_firmy"));
            department.setName(resultSet.getString("nazwa"));
            department.setMinNumberOfEmployees(resultSet.getInt("min_liczba_pracownikow"));
            department.setMaxNumberOfEmployees(resultSet.getInt("max_liczba_pracownikow"));

        }
        statement.close();
        return department;
    }

    @Override
    public List<Department> getListOfObjects() throws SQLException {
        System.out.println("Operacja w department repository");
        ArrayList<Department> departments = new ArrayList<>();
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_dzial_firmy, FROM biuro.dzial_firmy");
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            Department department = new Department();
//            department.getDepartmentCategory().setCategoryName(resultSet.getString("kategoria"));
//            System.out.println(resultSet.getInt("id_produkt"));
//            System.out.println(resultSet.getString("produkt"));
//            System.out.println(resultSet.getInt("cena"));
//            System.out.println(resultSet.getString("kategoria"));
//
//            department.setId(resultSet.getInt("id_produkt"));
//            department.setName(resultSet.getString("produkt"));
//            department.setPrice(resultSet.getInt("cena"));
//            department.getDepartmentCategory().setCategoryName(resultSet.getString("kategoria"));
//            departments.add(department);
//        }
//        statement.close();
        return departments;

    }

    public DepartmentDto getDtoObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_dzial_firmy, id_kierownik_dzial, id_oddzial, nazwa, max_liczba_pracownikow, min_liczba_pracownikow FROM biuro.dzial_firmy WHERE id_dzial_firmy = ?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        DepartmentDto department = null;
        while (resultSet.next()) {
            department = new DepartmentDto(resultSet.getInt("id_dzial_firmy"), resultSet.getString("nazwa"), resultSet.getInt("min_liczba_pracownikow"),resultSet.getInt("max_liczba_pracownikow"));
        }
        statement.close();
        return department;
    }
}
