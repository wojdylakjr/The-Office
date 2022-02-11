package services;

import database.DataBaseManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.Employee;
import modelsDAO.JobPosition;
import modelsDTO.DepartmentDto;
import modelsDTO.EmployeeDto;
import modelsFx.EmployeeRankingFx;
import modelsFx.OrdersViewFx;
import modelsFx.ProductInOrderFx;
import repositories.OrderRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeRankingService {
    private ObservableList<EmployeeRankingFx> employeeRankingFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<EmployeeRankingFx> ordersViewFxObjectProperty = new SimpleObjectProperty<>(new EmployeeRankingFx());

    public ObservableList<EmployeeRankingFx> getEmployeeRankingFxObservableList() {
        return employeeRankingFxObservableList;
    }

    public void setEmployeeRankingFxObservableList(ObservableList<EmployeeRankingFx> employeeRankingFxObservableList) {
        this.employeeRankingFxObservableList = employeeRankingFxObservableList;
    }

    public EmployeeRankingFx getOrdersViewFxObjectProperty() {
        return ordersViewFxObjectProperty.get();
    }

    public ObjectProperty<EmployeeRankingFx> ordersViewFxObjectPropertyProperty() {
        return ordersViewFxObjectProperty;
    }

    public void setOrdersViewFxObjectProperty(EmployeeRankingFx ordersViewFxObjectProperty) {
        this.ordersViewFxObjectProperty.set(ordersViewFxObjectProperty);
    }

    public void list() throws SQLException {
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("select * from ranking_sprzedawcow");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            EmployeeRankingFx employee = new EmployeeRankingFx(resultSet.getString("pracownik_imie"), resultSet.getString("pracownik_nazwisko"), resultSet.getInt("przychod"), resultSet.getInt("ilosc_klientow"), resultSet.getInt("ilosc_zamowien"));
            employeeRankingFxObservableList.add(employee);
        }
        statement.close();
    }
}
