package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelsFx.EmployeeRankingFx;
import services.EmployeeRankingService;

import java.sql.SQLException;

public class EmployeeRankingController {
    @FXML
    public TableView<EmployeeRankingFx> employeeRankingTableView;
    @FXML
    public TableColumn<EmployeeRankingFx, String> firstNameColumn;
    @FXML
    public TableColumn<EmployeeRankingFx, String> lastNameColumn;
    @FXML
    public TableColumn<EmployeeRankingFx, Number> incomeColumn;

    private EmployeeRankingService employeeRankingService;

    public void initialize(){
        employeeRankingService = new EmployeeRankingService();
        this.list();

        this.employeeRankingTableView.setItems(this.employeeRankingService.getEmployeeRankingFxObservableList());
        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        this.incomeColumn.setCellValueFactory(cellData -> cellData.getValue().incomeProperty());
    }

    private void list() {
        try {
            this.employeeRankingService.list();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
