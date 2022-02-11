package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelsFx.JobPositionDetailsFx;
import services.JobPositionDetailsService;

import java.sql.SQLException;

public class JobPositionDetailsController {
    @FXML
    public TableView<JobPositionDetailsFx> jobPositionDetailsTableView;
    @FXML
    public TableColumn<JobPositionDetailsFx, String> positionColumn;
    @FXML
    public TableColumn<JobPositionDetailsFx, Number> averageSalaryColumn;
    @FXML
    public TableColumn<JobPositionDetailsFx, Number> maxSalaryColumn;
    @FXML
    public TableColumn<JobPositionDetailsFx, Number> minSalaryColumn;
    @FXML
    public TableColumn<JobPositionDetailsFx, Number> numberOfEmployeesColumn;
    @FXML
    public TableColumn<JobPositionDetailsFx, Number> numberOfBonusesColumn;

    private JobPositionDetailsService jobPositionDetailsService;

    public void initialize() {
        this.jobPositionDetailsService = new JobPositionDetailsService();
        this.list();
        this.jobPositionDetailsTableView.setItems(this.jobPositionDetailsService.getJobPositionDetailsServiceFxObservableList());
        this.positionColumn.setCellValueFactory(cellData -> cellData.getValue().jobPositionNameProperty());
        this.averageSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().averageSalaryProperty());
        this.maxSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().maxSalaryProperty());
        this.minSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().minSalaryProperty());
        this.numberOfEmployeesColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfEmployeesProperty());
        this.numberOfBonusesColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfBonusesProperty());

    }

    private void list() {
        try {
            this.jobPositionDetailsService.list();
        } catch (SQLException e) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a1.show();
            e.printStackTrace();
        }
    }
}
