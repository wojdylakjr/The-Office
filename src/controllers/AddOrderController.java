package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
//        this.addOrderPositionComboBox.setPlaceholder(new Label("Wybierz najpierw szefa"));
        this.employeesComboBox.setItems(this.addOrderService.getEmployeeFxObservableList());
        this.productsComboBox.setItems(this.addOrderService.getProductFxObservableList());
        //dodawanie
//lista produkotw
        this.addOrderService.addOrderFxObjectPropertyProperty().get().quantityProperty().bind(this.quantityTextField.textProperty());
        this.addOrderService.addOrderFxObjectPropertyProperty().get().productProperty().bind(this.productsComboBox.valueProperty());

        //zamowienie
        this.addOrderService.orderFxObjectPropertyProperty().get().clientProperty().bind(this.clientsComboBox.valueProperty());
        this.addOrderService.orderFxObjectPropertyProperty().get().employeeProperty().bind(this.employeesComboBox.valueProperty());

        //tu ustalam co jest wymagane
//        this.addaddOrderButton.disableProperty().bind(this.addOrderFirstName.textProperty().isEmpty().or(this.addOrderSalary.textProperty().isEmpty()).or(this.addOrderPositionComboBox.valueProperty().isNull()));
        //wyswietlanie
        this.productsTableView.setItems(this.addOrderService.getProductsInOrderFxObservableList());
        this.productsColumn.setCellValueFactory(cellData -> cellData.getValue().productProperty());
        this.quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());


        //edytowanie
//        this.addOrderFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        this.addOrderLastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        this.addOrderSalaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
//        this.addOrderBonusColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    public void clientsComboBoxOnAction(ActionEvent actionEvent) {
    }

    public void employeesComboBoxOnAction(ActionEvent actionEvent) {
    }

    public void addProductOnAction(ActionEvent actionEvent) {
        System.out.println("przycisk");
        try {
            this.addOrderService.addProducts();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        this.listProducts();
    }


    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void addOrderOnAction(ActionEvent actionEvent) {
        try {
            this.addOrderService.addOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void listProducts() {


        try {
            this.addOrderService.list();
        } catch (SQLException | CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void init(){
        try {
            this.addOrderService.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
