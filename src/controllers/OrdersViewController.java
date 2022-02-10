package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import modelsFx.ClientFx;
import modelsFx.EmployeeFx;
import modelsFx.OrdersViewFx;
import modelsFx.ProductInOrderFx;
import services.OrdersViewService;
import services.ProductService;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrdersViewController {
    @FXML
    public TableView<OrdersViewFx> ordersTableView;
    @FXML
    public TableColumn<OrdersViewFx, ClientFx> clientColumn;
    @FXML
    public TableColumn<OrdersViewFx, EmployeeFx> employeeColumn;
    @FXML
//    public TableColumn<OrdersViewFx, LocalDateTime> dateColumn;
    public TableColumn<OrdersViewFx, String> dateColumn;
    @FXML
    public TableColumn<OrdersViewFx, ListView<ProductInOrderFx>> productListColumn;

OrdersViewService ordersViewService;
    public void initialize() {
        this.ordersViewService = new OrdersViewService();
        this.listOrders();

        //wyswietlanie
        this.ordersTableView.setItems(this.ordersViewService.getOrdersViewFxObservableList());
        this.clientColumn.setCellValueFactory(cellData -> cellData.getValue().clientProperty());
        this.employeeColumn.setCellValueFactory(cellData -> cellData.getValue().employeeProperty());
        this.dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateTimeProperty());
        this.productListColumn.setCellValueFactory(cellData -> cellData.getValue().productListProperty());


        //edytowanie


        //zaznaczony wiersz
        this.ordersTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.ordersViewService.setOrdersViewFxObjectPropertyUpdate(newValue);
        });
    }

    private void listOrders() {
        try {
            this.ordersViewService.list();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void deleteCategoryOnAction(ActionEvent actionEvent) {
        System.out.println("usuwam");
        try {
            this.ordersViewService.deleteOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listOrders();
    }
}
