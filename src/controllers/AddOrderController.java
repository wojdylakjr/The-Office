package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import modelsFx.ClientFx;
import modelsFx.EmployeeFx;
import modelsFx.ProductFx;
import modelsFx.ProductInOrderFx;
import services.AddOrderService;

import java.sql.SQLException;

public class AddOrderController {
    @FXML
    public TextField quantityTextField;
    @FXML
    public ComboBox<ClientFx> clientsComboBox;
    @FXML
    public ComboBox<EmployeeFx> employeesComboBox;
    @FXML
    public ComboBox<ProductFx> productsComboBox;
    @FXML
    public Button addProductButton;
    @FXML
    public TableView<ProductInOrderFx> productsTableView = new TableView<>();
    @FXML
    public TableColumn<ProductInOrderFx, ProductFx> productsColumn;
    @FXML
    public TableColumn<ProductInOrderFx, String> quantityColumn;
    @FXML
    public MenuItem deleteMenuItem;
    @FXML
    public Button addOrderButton;


    private AddOrderService addOrderService;

    public void initialize() {
        this.addOrderService = new AddOrderService();
        this.init();

        this.clientsComboBox.setItems(this.addOrderService.getClientFxObservableList());
        this.employeesComboBox.setItems(this.addOrderService.getEmployeeFxObservableList());
        this.productsComboBox.setItems(this.addOrderService.getProductFxObservableList());


        //dodawanie
//lista produkotw
        this.addOrderService.addOrderFxObjectPropertyProperty().get().quantityProperty().bind(this.quantityTextField.textProperty());
        this.addOrderService.addOrderFxObjectPropertyProperty().get().productProperty().bind(this.productsComboBox.valueProperty());

        //zamowienie
        this.addOrderService.orderFxObjectPropertyProperty().get().clientProperty().bind(this.clientsComboBox.valueProperty());
        this.addOrderService.orderFxObjectPropertyProperty().get().employeeProperty().bind(this.employeesComboBox.valueProperty());

        //wyswietlanie
        this.productsTableView.setItems(this.addOrderService.getProductsInOrderFxObservableList());
        this.productsColumn.setCellValueFactory(cellData -> cellData.getValue().productProperty());
        this.quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());

        //warunek
        this.addProductButton.disableProperty().bind(this.quantityTextField.textProperty().isEmpty().or(this.productsComboBox.valueProperty().isNull()));
        this.addOrderButton.disableProperty().bind(this.employeesComboBox.valueProperty().isNull().or(this.clientsComboBox.valueProperty().isNull()));

//edytowanie
        this.quantityColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        //zaznaczony wiersz
        this.productsTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.addOrderService.setAddOrderFxObjectPropertyUpdate(newValue);

        });

    }

    public void clientsComboBoxOnAction(ActionEvent actionEvent) {
    }

    public void employeesComboBoxOnAction(ActionEvent actionEvent) {
    }

    public void addProductOnAction(ActionEvent actionEvent) {
//        System.out.println("przycisk");
        try {
            this.addOrderService.addProducts();
        } catch (CloneNotSupportedException e) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a1.show();
            e.printStackTrace();
        }
        this.listProducts();
    }


    public void deleteOnAction(ActionEvent actionEvent) {
//        System.out.println("Usuwam");
        this.addOrderService.delete();
        this.listProducts();
    }

    public void addOrderOnAction(ActionEvent actionEvent) {
        try {
            this.addOrderService.addOrder();
        } catch (SQLException e) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a1.show();
            e.printStackTrace();
        }
    }


    public void listProducts() {


        try {
            this.addOrderService.list();
        } catch (SQLException | CloneNotSupportedException e) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a1.show();
            e.printStackTrace();
        }
    }

    public void init() {
        try {
            this.addOrderService.init();
        } catch (SQLException e) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a1.show();
            e.printStackTrace();
        }
    }

    @FXML
    public void quantityColumnOnEdit(TableColumn.CellEditEvent<ProductInOrderFx, String> productInOrderFxStringCellEditEvent) {
        this.addOrderService.getAddOrderFxObjectPropertyUpdate().setQuantity(productInOrderFxStringCellEditEvent.getNewValue());
    }
}
