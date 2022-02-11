package repositories;

import database.DataBaseManager;
import javafx.collections.ObservableList;
import modelsDAO.Employee;
import modelsDAO.Order;
import modelsDTO.EmployeeDto;
import modelsFx.ClientFx;
import modelsFx.EmployeeFx;
import modelsFx.OrdersViewFx;
import modelsFx.ProductInOrderFx;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements Repository<Order> {

    @Override
    public void save(Order order) throws SQLException {
        System.out.println("Dodanie w order repository zamowienia:");
        System.out.println(order);
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.zamowienie(id_klient, id_pracownik, data) VALUES(?,?,?)");
        statement.setInt(1, order.getClient().getId());
        statement.setInt(2, order.getEmployee().getId());
        statement.setTimestamp(3, order.getSqlTimestamp());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        System.out.println("usuwanie zamoiwniea  w repository");
//        System.out.println("Employee repo, imie: " + employee.getName()+", nazwisko: " + employee.getName() +", id: " + employee.getId() );
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.szczegoly_zamowienia WHERE id_zamowienie = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();

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
        statement.setTimestamp(1, order.getSqlTimestamp());
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
        statement.setInt(2, product.getProduct().getId());
        statement.setInt(3, Integer.parseInt(product.getQuantity()));
        statement.executeUpdate();
        statement.close();
    }

    public void getOrders(ObservableList<OrdersViewFx> ordersViewFxObservableList) throws SQLException {
//        ArrayList<ProductInOrderFx> temp = new ArrayList<>();
//        temp.add(new ProductInOrderFx());
//        temp.add(new ProductInOrderFx());
//        ordersViewFxObservableList.add(new OrdersViewFx(1,"czwartek",temp, new ClientFx(), new EmployeeFx()  ));


        PreparedStatement statement = DataBaseManager.connection.prepareStatement("select id_zamowienie, klient_imie, klient_nazwisko, pracownik_imie, pracownik_nazwisko, data, nazwa, ilosc, cena from zamowienia order by data desc;");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
//        Timestamp datetime;

        while (!resultSet.isAfterLast()) {
            Timestamp datetime = resultSet.getTimestamp("data");
            int id = resultSet.getInt("id_zamowienie");
            ClientFx tempClient = new ClientFx(resultSet.getString("klient_imie"), resultSet.getString("klient_nazwisko"));
            EmployeeFx tempEmployee = new EmployeeFx(resultSet.getString("pracownik_imie"), resultSet.getString("pracownik_nazwisko"));
            ArrayList<ProductInOrderFx> tempProductList = new ArrayList<>();
            tempProductList.add(new ProductInOrderFx(resultSet.getString("nazwa"), resultSet.getString("ilosc"), resultSet.getInt("cena")));
            System.out.println("id" + resultSet.getString("id_zamowienie"));
            System.out.println("resultSet" + resultSet.getTimestamp("data"));
            System.out.println("pobrane " + datetime);
            while (resultSet.next() && datetime.equals(resultSet.getTimestamp("data"))) {
                tempProductList.add(new ProductInOrderFx(resultSet.getString("nazwa"), resultSet.getString("ilosc"), resultSet.getInt("cena")));
            }

            ordersViewFxObservableList.add(new OrdersViewFx(id, datetime.toString(), tempProductList, tempClient, tempEmployee));
//            System.out.println(datetime);
        }
        statement.close();
//        return id;
    }
}
