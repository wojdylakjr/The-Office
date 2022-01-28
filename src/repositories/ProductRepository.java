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

public class ProductRepository implements Repository<Product> {


    @Override
    public void save(Product product) throws SQLException {
        System.out.println("Operacja w product repository");
        System.out.println(product);
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Produkt(nazwa, cena, id_kategoria) VALUES(?,?,?)");
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.setInt(3, product.getProductCategory().getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("Operacja w product repository");
////        System.out.println("Product repo, imie: " + product.getName()+", nazwisko: " + product.getName() +", id: " + product.getId() );
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.produkt WHERE id_produkt = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void update(Product product) throws SQLException {
//        System.out.println("Operacja w product repository");
//        System.out.println("Product repo, imie: " + product.getName() + ", nazwisko: " + product.getName() + ", id: " + product.getId());
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.produkt SET nazwa = ?, cena = ? WHERE id_produkt = ?");
        statement.setString(1, product.getName());
        statement.setInt(2, product.getPrice());
        statement.setInt(3, product.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public Product getObject(int id) {
        return null;
    }

    @Override
    public List<Product> getListOfObjects() throws SQLException {
        System.out.println("Operacja w product repository");
        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_produkt, produkt.nazwa AS \"produkt\", cena, kategoria.nazwa as \"kategoria\" FROM biuro.produkt\n" +
                                                                                      "JOIN biuro.kategoria ON produkt.id_kategoria = kategoria.id_kategoria");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Product product = new Product();
            product.getProductCategory().setCategoryName(resultSet.getString("kategoria"));
            System.out.println(resultSet.getInt("id_produkt"));
            System.out.println(resultSet.getString("produkt"));
            System.out.println(resultSet.getInt("cena"));
            System.out.println(resultSet.getString("kategoria"));

            product.setId(resultSet.getInt("id_produkt"));
            product.setName(resultSet.getString("produkt"));
            product.setPrice(resultSet.getInt("cena"));
            product.getProductCategory().setCategoryName(resultSet.getString("kategoria"));
            products.add(product);
        }
        statement.close();
        return products;

    }
}
