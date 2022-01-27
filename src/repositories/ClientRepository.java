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

public class ClientRepository implements Repository<Client> {


    @Override
    public void save(Client client) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Klient(imie, nazwisko) VALUES(?,?)");
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
//        System.out.println("Client repo, imie: " + client.getFirstName()+", nazwisko: " + client.getFirstName() +", id: " + client.getId() );
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.klient WHERE id_klient = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void update(Client client) throws SQLException {
        System.out.println("Client repo, imie: " + client.getFirstName() + ", nazwisko: " + client.getFirstName() + ", id: " + client.getId());
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.klient SET imie = ?, nazwisko = ? WHERE id_klient = ?");
        statement.setString(1, client.getFirstName());
        statement.setString(2, client.getLastName());
        statement.setInt(3, client.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public Client getObject(int id) {
        return null;
    }

    @Override
    public List<Client> getListOfObjects() throws SQLException {
        ArrayList<Client> clients = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_klient, imie, nazwisko FROM biuro.Klient");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Client client = new Client();
            client.setId(resultSet.getInt("id_klient"));
            client.setFirstName(resultSet.getString("imie"));
            client.setLastName(resultSet.getString("nazwisko"));
            clients.add(client);
        }
        statement.close();
        return clients;
    }
}
