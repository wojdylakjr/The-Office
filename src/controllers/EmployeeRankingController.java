package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    @FXML
    public TableColumn <EmployeeRankingFx, Number>ordersColumn;
    @FXML
    public TableColumn <EmployeeRankingFx, Number>clientsOrder;

    private EmployeeRankingService employeeRankingService;

    public void initialize(){
        employeeRankingService = new EmployeeRankingService();
        this.list();

        this.employeeRankingTableView.setItems(this.employeeRankingService.getEmployeeRankingFxObservableList());
        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        this.incomeColumn.setCellValueFactory(cellData -> cellData.getValue().incomeProperty());
        this.ordersColumn.setCellValueFactory(cellData -> cellData.getValue().ordersProperty());
        this.clientsOrder.setCellValueFactory(cellData -> cellData.getValue().clientsProperty());
    }

    private void list() {
        try {
            this.employeeRankingService.list();
        } catch (SQLException e) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a1.show();
            e.printStackTrace();
        }
    }
}
