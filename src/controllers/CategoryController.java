package controllers;

import modelsFx.CategoryFx;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import services.CategoryService;

import java.sql.SQLException;

public class CategoryController {
    //dodawanie
    @FXML
    private TextField categoryName;

    @FXML
    private Button addCategoryButton;

    //wyswietlanie i edycja

    @FXML
    private TableView<CategoryFx> categoryTableView;

    @FXML
    private TableColumn<CategoryFx, String> idColumn;

    @FXML
    private TableColumn<CategoryFx, String> categoryNameColumn;



    //usuwanie
    @FXML
    private MenuItem deleteMenuItem;

    private CategoryService categoryService;

    public void initialize() {
        this.categoryService = new CategoryService();
        this.listCategories();
        //dodawanie
        this.categoryService.categoryFxObjectPropertyProperty().get().categoryNameProperty().bind(this.categoryName.textProperty());
        this.addCategoryButton.disableProperty().bind(this.categoryName.textProperty().isEmpty());
        //wyswietlanie
        this.categoryTableView.setItems(this.categoryService.getCategoryFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.categoryNameColumn.setCellValueFactory(cellData -> cellData.getValue().categoryNameProperty());


        //edytowanie
        this.categoryNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        //zaznaczony wiersz
        this.categoryTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.categoryService.setCategoryFxObjectPropertyUpdate(newValue);
        });
    }

    //obsluga przycisku do zapisu
    @FXML
    public void addCategoryOnAction() {
        System.out.println("Wcisnieto przycisk");
        try {
            this.categoryService.saveCategoryInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listCategories();
    }

    public void listCategories() {
        try {
            this.categoryService.listCategories();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //edycja konkretnych kolumn
    @FXML
    public void onEditCommitCategoryName(TableColumn.CellEditEvent<CategoryFx, String> categoryFxStringCellEditEvent) {
        this.categoryService.getCategoryFxObjectPropertyUpdate().setCategoryName(categoryFxStringCellEditEvent.getNewValue());
//        this.categoryService.getCategoryFxObjectPropertyUpdate().setLastName(categoryFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }



    private void updateInDatabase() {
        try {
            System.out.println("category controller");
            this.categoryService.updateCategoryInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listCategories();
    }

    @FXML
    public void deleteCategoryOnAction() {
        try {
            this.categoryService.deleteCategoryInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listCategories();
    }


}