package repositories;

import database.DataBaseManager;
import models.*;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ClientRepository implements Repository<Client> {
    private Statement query;
    public ClientRepository() {
        try{
            this.query = DataBaseManager.connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void save(Client client) throws SQLException {
        String sql = "INSERT INTO biuro.Klient(imie, nazwisko) VALUES('" + client.getFirstName() + "', '" + client.getLastName() +"')";
        query.executeUpdate(sql);
//        System.out.println("Zapis do bazy klienta: " + client.getFirstName() + " " + client.getLastName());
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
