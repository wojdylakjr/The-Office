package repositories;

import database.DataBaseManager;
import modelsDAO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobPositionRepository implements Repository<JobPosition> {


    //TODO: Sprawdzic czy podane wartosci nie sa puste
    @Override
    public void save(JobPosition position) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Stanowisko(nazwa, min_pensja, max_pensja) VALUES(?,?,?)");
        statement.setString(1, position.getPositionName());
        statement.setInt(2, position.getMinSalary());
        statement.setInt(3, position.getMaxSalary());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.Stanowisko WHERE id_stanowisko = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void update(JobPosition position) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.Stanowisko SET nazwa = ?, min_pensja = ? , max_pensja = ? WHERE id_stanowisko = ?");
        statement.setString(1, position.getPositionName());
        statement.setInt(2, position.getMinSalary());
        statement.setInt(3, position.getMaxSalary());
        statement.setInt(4, position.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public JobPosition getObject(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_stanowisko, nazwa, min_pensja, max_pensja FROM biuro.Stanowisko WHERE id_stanowisko = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        JobPosition jobPosition = null;
        while (resultSet.next()) {
            jobPosition = new JobPosition(resultSet.getInt("id_stanowisko"), resultSet.getString("nazwa"), resultSet.getInt("min_pensja"), resultSet.getInt("max_pensja"));
        }
        statement.close();
        return jobPosition;
    }

    @Override
    public List<JobPosition> getListOfObjects() throws SQLException {
        ArrayList<JobPosition> jobPositions = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_stanowisko, nazwa, min_pensja, max_pensja FROM biuro.Stanowisko");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            JobPosition jobPosition = new JobPosition(resultSet.getInt("id_stanowisko"), resultSet.getString("nazwa"), resultSet.getInt("min_pensja"), resultSet.getInt("max_pensja"));
            jobPositions.add(jobPosition);
        }
        statement.close();
        return jobPositions;
    }
}
