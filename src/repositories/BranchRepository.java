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

public class BranchRepository implements Repository<Branch> {


    @Override
    public void save(Branch branch) throws SQLException {
        System.out.println("Operacja w branch repository");
//        System.out.println(branch);
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Produkt(nazwa, cena, id_kategoria) VALUES(?,?,?)");
//        statement.setString(1, branch.getCityName());
//        statement.setInt(3, branch.getBranchManager().getId());
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("Operacja w branch repository");
////        System.out.println("Branch repo, imie: " + branch.getCityName()+", nazwisko: " + branch.getCityName() +", id: " + branch.getId() );
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.produkt WHERE id_produkt = ?");
//        statement.setInt(1, id);
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public void update(Branch branch) throws SQLException {
//        System.out.println("Operacja w branch repository");
//        System.out.println("Branch repo, imie: " + branch.getCityName() + ", nazwisko: " + branch.getCityName() + ", id: " + branch.getId());
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.produkt SET nazwa = ?, cena = ? WHERE id_produkt = ?");
//        statement.setString(1, branch.getCityName());
//        statement.setInt(3, branch.getId());
//        statement.executeUpdate();
//        statement.close();
    }

    @Override
    public Branch getObject(int id) {
        return null;
    }

    @Override
    public List<Branch> getListOfObjects() throws SQLException {
        System.out.println("Operacja w branch repository");
        ArrayList<Branch> branchs = new ArrayList<>();
//        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_produkt, produkt.nazwa AS \"produkt\", cena, kategoria.nazwa as \"kategoria\" FROM biuro.produkt\n" +
//                "JOIN biuro.kategoria ON produkt.id_kategoria = kategoria.id_kategoria");
//        ResultSet resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            Branch branch = new Branch();
//            branch.getBranchManager().setEmployeeCityName(resultSet.getString("kategoria"));
//            System.out.println(resultSet.getInt("id_produkt"));
//            System.out.println(resultSet.getString("produkt"));
//            System.out.println(resultSet.getInt("cena"));
//            System.out.println(resultSet.getString("kategoria"));
//
//            branch.setId(resultSet.getInt("id_produkt"));
//            branch.setCityName(resultSet.getString("produkt"));
//            branch.getBranchManager().setEmployeeCityName(resultSet.getString("kategoria"));
//            branchs.add(branch);
//        }
//        statement.close();
        return branchs;

    }
}
