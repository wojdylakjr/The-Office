package repositories;

import database.DataBaseManager;
import modelsDAO.*;
import modelsDTO.BranchDto;
import modelsDTO.DepartmentDto;
import modelsDTO.EmployeeDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository implements Repository<Department> {


    @Override
    public void save(Department department) throws SQLException {
        System.out.println("Dodanie  w department repository");
        System.out.println(department);
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.dzial_firmy(nazwa, max_liczba_pracownikow, min_liczba_pracownikow, id_kierownik_dzial, id_oddzial) VALUES(?,?,?,?,?)");
        statement.setString(1, department.getName());
        statement.setInt(2, department.getMaxNumberOfEmployees());
        statement.setInt(3, department.getMinNumberOfEmployees());
        statement.setInt(4, department.getDepartmentManager().getId());
        statement.setInt(5, department.getDepartmentBranch().getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("Operacja w department repository");
////        System.out.println("Department repo, imie: " + department.getName()+", nazwisko: " + department.getName() +", id: " + department.getId() );
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.dzial_firmy WHERE id_dzial_firmy = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void update(Department department) throws SQLException {
        System.out.println("Operacja w department repository");
//        System.out.println("Department repo, imie: " + department.getName() + ", nazwisko: " + department.getName() + ", id: " + department.getId());
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.dzial_firmy SET nazwa = ?,  max_liczba_pracownikow = ?, min_liczba_pracownikow = ? WHERE id_dzial_firmy = ?");
        statement.setString(1, department.getName());
        statement.setInt(2, department.getMaxNumberOfEmployees());
        statement.setInt(3, department.getMinNumberOfEmployees());
        statement.setInt(4, department.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public Department getObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_dzial_firmy, id_kierownik_dzial, id_oddzial, nazwa, max_liczba_pracownikow, min_liczba_pracownikow FROM biuro.dzial_firmy WHERE id_dzial_firmy = ?");
        statement.setInt(1, id);
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
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("select dzial_firmy.id_dzial_firmy as id, dzial_firmy.nazwa as dzial_firmy, max_liczba_pracownikow, min_liczba_pracownikow, pracownik.imie as kierownik_imie,\n" +
                "pracownik.nazwisko as kierownik_nazwisko, oddzial.miasto as oddzial\n" +
                "from biuro.dzial_firmy\n" +
                "join biuro.pracownik on id_kierownik_dzial = id_pracownik\n" +
                "join biuro.oddzial on oddzial.id_oddzial = dzial_firmy.id_oddzial\n");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Department department = new Department(resultSet.getInt("id"), resultSet.getString("dzial_firmy"), resultSet.getInt("max_liczba_pracownikow"), resultSet.getInt("min_liczba_pracownikow"), new EmployeeDto(resultSet.getString("kierownik_imie"), resultSet.getString("kierownik_nazwisko")),
                    new BranchDto(resultSet.getString("oddzial")));
            departments.add(department);
        }
        statement.close();
        return departments;

    }

    public DepartmentDto getDtoObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_dzial_firmy, id_kierownik_dzial, id_oddzial, nazwa, max_liczba_pracownikow, min_liczba_pracownikow FROM biuro.dzial_firmy WHERE id_dzial_firmy = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        DepartmentDto department = null;
        while (resultSet.next()) {
            department = new DepartmentDto(resultSet.getInt("id_dzial_firmy"), resultSet.getString("nazwa"), resultSet.getInt("min_liczba_pracownikow"), resultSet.getInt("max_liczba_pracownikow"));
        }
        statement.close();
        return department;
    }
}
