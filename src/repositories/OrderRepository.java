package repositories;

import database.DataBaseManager;
import modelsDAO.Order;
import modelsDTO.EmployeeDto;
import modelsFx.ProductInOrderFx;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderRepository implements Repository<Order>{

    @Override
    public void save(Order order) throws SQLException {
        System.out.println("Dodanie w order repository zamowienia:");
        System.out.println(order);
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.zamowienie(id_klient, id_pracownik, data) VALUES(?,?,?)");
        statement.setInt(1, order.getClient().getId());
        statement.setInt(2,order.getEmployee().getId());
        statement.setTimestamp(3,order.getSqlTimestamp());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {

    }

    @Override
    public void update(Order object) throws SQLException {

    }

    @Override
    public Order getObject(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Order> getListOfObjects() throws SQLException {
        return null;
    }


    public int getOrderId(Order order) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_zamowienie FROM biuro.zamowienie WHERE data = ?");
        statement.setTimestamp(1,order.getSqlTimestamp());
        ResultSet resultSet = statement.executeQuery();
        int id = 0;
        while (resultSet.next()) {
            id = resultSet.getInt("id_zamowienie");
        }
        statement.close();
        return id;
    }

    public void saveDetailOrder(Order order, ProductInOrderFx product) throws SQLException {
        System.out.println("Dodanie do szczegoly_zamowienia w repository zamowienia:");
//        System.out.println(order);
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.szczegoly_zamowienia(id_zamowienie, id_produkt, ilosc) VALUES(?,?,?)");
        statement.setInt(1, order.getId());
        statement.setInt(2,product.getProduct().getId());
        statement.setInt(3,Integer.parseInt(product.getQuantity()));
        statement.executeUpdate();
        statement.close();
    }
}
