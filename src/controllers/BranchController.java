package controllers;

import modelsFx.EmployeeFx;
import modelsFx.BranchFx;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import services.BranchService;

import java.sql.SQLException;

public class BranchController {
    //dodawanie
    @FXML
    private TextField branchCityName;


    @FXML
    private ComboBox<EmployeeFx> branchDirectorComboBox;

    @FXML
    private Button addBranchButton;

    //wyswietlanie i edycja

    @FXML
    private TableView<BranchFx> branchTableView;

    @FXML
    private TableColumn<BranchFx, String> idColumn;

    @FXML
    private TableColumn<BranchFx, String> branchCityNameColumn;

    @FXML
    private TableColumn<BranchFx, EmployeeFx> branchDirectorColumn;

    //usuwanie
    @FXML
    private MenuItem deleteMenuItem;

    private BranchService branchService;

    public void initialize() {
        this.branchService = new BranchService();
        this.listBranches();
        //dodanie elementow do combo boxa
        System.out.println(this.branchService.getEmployeeFxObservableList());
        this.branchDirectorComboBox.setItems(this.branchService.getEmployeeFxObservableList());
        //dodawanie
        this.branchService.branchFxObjectPropertyProperty().get().cityNameProperty().bind(this.branchCityName.textProperty());

        this.branchService.branchFxObjectPropertyProperty().get().branchDirectorProperty().bind(this.branchDirectorComboBox.valueProperty());
        this.addBranchButton.disableProperty().bind(this.branchCityName.textProperty().isEmpty().or(this.branchDirectorComboBox.valueProperty().isNull()));
        //wyswietlanie
        this.branchTableView.setItems(this.branchService.getBranchFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.branchCityNameColumn.setCellValueFactory(cellData -> cellData.getValue().cityNameProperty());
        this.branchDirectorColumn.setCellValueFactory(cellData -> cellData.getValue().branchDirectorProperty());


        //edytowanie
        this.branchCityNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        //zaznaczony wiersz
        this.branchTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.branchService.setBranchFxObjectPropertyUpdate(newValue);
        });
    }

    //obsluga przycisku do zapisu
    @FXML
    public void addBranchOnAction() {
        System.out.println("Wcisnieto przycisk");
        try {
            this.branchService.saveBranchInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listBranches();
    }

    public void listBranches() {
        try {
            this.branchService.listBranches();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //edycja konkretnych kolumn
    @FXML
    public void onEditCommitBranchName(TableColumn.CellEditEvent<BranchFx, String> branchFxStringCellEditEvent) {
        this.branchService.getBranchFxObjectPropertyUpdate().setCityName(branchFxStringCellEditEvent.getNewValue());
//        this.branchService.getBranchFxObjectPropertyUpdate().setLastName(branchFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }


    private void updateInDatabase() {
        try {
            System.out.println("branch controller");
            this.branchService.updateBranchInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listBranches();
    }

    @FXML
    public void deleteBranchOnAction() {
        try {
            this.branchService.deleteBranchInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listBranches();
    }



}