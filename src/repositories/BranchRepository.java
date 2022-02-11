package repositories;

import database.DataBaseManager;
import modelsDAO.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchRepository implements Repository<Branch> {


    @Override
    public void save(Branch branch) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("INSERT INTO biuro.Oddzial(miasto, id_dyrektor_oddzial) VALUES(?,?)");
        statement.setString(1, branch.getCityName());
        statement.setInt(2, branch.getBranchDirector().getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("DELETE FROM biuro.Oddzial WHERE id_oddzial = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public void update(Branch branch) throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("UPDATE biuro.oddzial SET miasto = ? WHERE id_oddzial = ?");
        statement.setString(1, branch.getCityName());
        statement.setInt(2, branch.getId());
        statement.executeUpdate();
        statement.close();
    }

    @Override
    public Branch getObject(int id) {
        return null;
    }

    @Override
    public List<Branch> getListOfObjects() throws SQLException {
        System.out.println("Operacja w branch repository");
        ArrayList<Branch> branchs = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("SELECT id_oddzial,id_dyrektor_oddzial, miasto FROM biuro.oddzial");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Branch branch = new Branch(resultSet.getInt("id_oddzial"), resultSet.getString("miasto"));
            branch.setBranchDirectorFromDatabase(resultSet.getInt("id_dyrektor_oddzial"));
            branchs.add(branch);
        }
        statement.close();
        return branchs;

    }
}
