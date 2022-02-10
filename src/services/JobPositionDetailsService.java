package services;

import database.DataBaseManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsFx.EmployeeRankingFx;
import modelsFx.JobPositionDetailsFx;
import modelsFx.ProductRankingFx;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobPositionDetailsService {
    private ObservableList<JobPositionDetailsFx> jobPositionDetailsServiceFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<JobPositionDetailsFx> jobPositionDetailsServiceFxObjectProperty = new SimpleObjectProperty<>(new JobPositionDetailsFx());

    public ObservableList<JobPositionDetailsFx> getJobPositionDetailsServiceFxObservableList() {
        return jobPositionDetailsServiceFxObservableList;
    }

    public void setJobPositionDetailsServiceFxObservableList(ObservableList<JobPositionDetailsFx> jobPositionDetailsServiceFxObservableList) {
        this.jobPositionDetailsServiceFxObservableList = jobPositionDetailsServiceFxObservableList;
    }

    public JobPositionDetailsFx getJobPositionDetailsServiceFxObjectProperty() {
        return jobPositionDetailsServiceFxObjectProperty.get();
    }

    public ObjectProperty<JobPositionDetailsFx> jobPositionDetailsServiceFxObjectPropertyProperty() {
        return jobPositionDetailsServiceFxObjectProperty;
    }

    public void setJobPositionDetailsServiceFxObjectProperty(JobPositionDetailsFx jobPositionDetailsServiceFxObjectProperty) {
        this.jobPositionDetailsServiceFxObjectProperty.set(jobPositionDetailsServiceFxObjectProperty);
    }

    public void list() throws SQLException {
//        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("select * from szczegoly_stanowiska");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            JobPositionDetailsFx  listElement= new JobPositionDetailsFx(resultSet.getString("min"), resultSet.getInt("srednia_wyplata"),resultSet.getInt("max_wyplata"), resultSet.getInt("min_wyplata"), resultSet.getInt("pracownicy_stanowisko"), resultSet.getInt("ilosc_premii"));
            jobPositionDetailsServiceFxObservableList.add(listElement);

        }
        statement.close();

    }
}
