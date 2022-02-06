package repositories;

import database.DataBaseManager;
import modelsDAO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements Repository<Category> {


    @Override
    public void save(Category client) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Kategoria(nazwa) VALUES(?)");
        statement.setString(1, client.getCategoryName());
        statement.executeUpdate();
        statement.close();


    }

    @Override
    public void delete(int id) throws SQLException {
//        System.out.println("Client repo, imie: " + client.getFirstName()+", nazwisko: " + client.getFirstName() +", id: " + client.getId() );
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.Kategoria WHERE id_kategoria = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void update(Category client) throws SQLException {
       // System.out.println("Client repo, imie: " + client.getFirstName() + ", nazwisko: " + client.getFirstName() + ", id: " + client.getId());
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.Kategoria SET nazwa = ? WHERE id_kategoria = ?");
        statement.setString(1, client.getCategoryName());
        statement.setInt(2, client.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public Category getObject(int id) {
        return null;
    }

    @Override
    public List<Category> getListOfObjects() throws SQLException {
        ArrayList<Category> categories = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_kategoria, nazwa FROM biuro.Kategoria");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Category category = new Category();
            category.setId(resultSet.getInt("id_kategoria"));
            category.setCategoryName(resultSet.getString("nazwa"));
            categories.add(category);
        }
        statement.close();
        return categories;
    }
}
