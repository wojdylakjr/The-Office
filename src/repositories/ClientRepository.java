package repositories;

import database.DataBaseManager;
import models.*;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientRepository implements Repository<Client> {


    @Override
    public void save(Client client) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Klient(imie, nazwisko) VALUES(?,?)");
        statement.setString(1,client.getFirstName());
        statement.setString(2,client.getLastName());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public Client getObject(int id) {
        return null;
    }

    @Override
    public List<Client> getListOfObjects() {
        return null;
    }
}
