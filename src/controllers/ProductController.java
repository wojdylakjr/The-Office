package controllers;

import modelsFx.CategoryFx;
import modelsFx.ProductFx;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import services.ProductService;

import java.sql.SQLException;

public class ProductController {
    //dodawanie
    @FXML
    private TextField productName;

    @FXML
    private TextField productPrice;

    @FXML
    private ComboBox<CategoryFx> productCategoryComboBox;

    @FXML
    private Button addProductButton;

    //wyswietlanie i edycja

    @FXML
    private TableView<ProductFx> productTableView;

    @FXML
    private TableColumn<ProductFx, Number> idColumn;

    @FXML
    private TableColumn<ProductFx, String> productNameColumn;

    @FXML
    private TableColumn<ProductFx, String> productPriceColumn;

    @FXML
    private TableColumn<ProductFx, CategoryFx> productCategoryColumn;

    //usuwanie
    @FXML
    private MenuItem deleteMenuItem;

    private ProductService productService;

    public void initialize() {
        this.productService = new ProductService();
        this.listProducts();
        //dodanie elementow do combo boxa
        System.out.println(this.productService.getCategoryFxObservableList());
        this.productCategoryComboBox.setItems(this.productService.getCategoryFxObservableList());
        //dodawanie
        this.productService.productFxObjectPropertyProperty().get().nameProperty().bind(this.productName.textProperty());
        this.productService.productFxObjectPropertyProperty().get().priceProperty().bind(this.productPrice.textProperty());
        this.productService.productFxObjectPropertyProperty().get().productCategoryProperty().bind(this.productCategoryComboBox.valueProperty());
        this.addProductButton.disableProperty().bind(this.productName.textProperty().isEmpty().or(this.productPrice.textProperty().isEmpty()).or(this.productCategoryComboBox.valueProperty().isNull()));
        //wyswietlanie
        this.productTableView.setItems(this.productService.getProductFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.productNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.productPriceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty());
        this.productCategoryColumn.setCellValueFactory(cellData -> cellData.getValue().productCategoryProperty());


        //edytowanie
        this.productNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.productPriceColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //zaznaczony wiersz
        this.productTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.productService.setProductFxObjectPropertyUpdate(newValue);
        });
    }

    //obsluga przycisku do zapisu
    @FXML
    public void addProductOnAction() {
        System.out.println("Wcisnieto przycisk");
        try {
            this.productService.saveProductInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listProducts();
    }

    public void listProducts() {
        try {
            this.productService.listProducts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //edycja konkretnych kolumn
    @FXML
    public void onEditCommitProductName(TableColumn.CellEditEvent<ProductFx, String> productFxStringCellEditEvent) {
        this.productService.getProductFxObjectPropertyUpdate().setName(productFxStringCellEditEvent.getNewValue());
//        this.productService.getProductFxObjectPropertyUpdate().setLastName(productFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitProductPrice(TableColumn.CellEditEvent<ProductFx, String> productFxStringCellEditEvent) {
        this.productService.getProductFxObjectPropertyUpdate().setPrice(Integer.parseInt(productFxStringCellEditEvent.getNewValue()));
//        this.productService.getProductFxObjectPropertyUpdate().setLastName(productFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    private void updateInDatabase() {
        try {
            System.out.println("product controller");
            this.productService.updateProductInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listProducts();
    }

    @FXML
    public void deleteProductOnAction() {
        try {
            this.productService.deleteProductInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listProducts();
    }



}