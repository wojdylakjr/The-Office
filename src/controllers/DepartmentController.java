package controllers;

import fxModels.BranchFx;
import fxModels.DepartmentFx;
import fxModels.EmployeeFx;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import services.DepartmentService;

import java.sql.SQLException;

public class DepartmentController {
    //dodawanie
    @FXML
    private TextField departmentName;

    @FXML
    private TextField departmentMaxNumberOfEmployees;

    @FXML
    private TextField departmentMinNumberOfEmployees;



    @FXML
    private ComboBox<EmployeeFx> departmentManagerComboBox;

    @FXML
    private ComboBox<BranchFx> departmentBranchComboBox;



    @FXML
    private Button addDepartmentButton;

    //wyswietlanie i edycja

    @FXML
    private TableView<DepartmentFx> departmentTableView;

    @FXML
    private TableColumn<DepartmentFx, String> idColumn;

    @FXML
    private TableColumn<DepartmentFx, String> departmentNameColumn;

    @FXML
    private TableColumn<DepartmentFx, String> departmentMaxNumberOfEmployeesColumn;

    @FXML
    private TableColumn<DepartmentFx, String> departmentMinNumberOfEmployeesColumn;


    @FXML
    private TableColumn<DepartmentFx, EmployeeFx> departmentManagerColumn;

    @FXML
    private TableColumn<DepartmentFx, BranchFx> departmentBranchColumn;



    //usuwanie
    @FXML
    private MenuItem deleteMenuItem;

    private DepartmentService departmentService;

    public void initialize() {
        this.departmentService = new DepartmentService();
        this.listDepartments();
        //dodanie elementow do combo boxa
//        System.out.println(this.departmentService.getEmployeeFxObservableList());
        this.departmentManagerComboBox.setItems(this.departmentService.getEmployeeFxObservableList());
        this.departmentBranchComboBox.setItems(this.departmentService.getBranchFxObservableList());

        //dodawanie
        this.departmentService.departmentFxObjectPropertyProperty().get().nameProperty().bind(this.departmentName.textProperty());
        this.departmentService.departmentFxObjectPropertyProperty().get().minNumberOfEmployeesProperty().bind(this.departmentMinNumberOfEmployeesColumn.textProperty());
        this.departmentService.departmentFxObjectPropertyProperty().get().maxNumberOfEmployeesProperty().bind(this.departmentMaxNumberOfEmployeesColumn.textProperty());
        this.departmentService.departmentFxObjectPropertyProperty().get().departmentManagerProperty().bind(this.departmentManagerComboBox.valueProperty());
        this.departmentService.departmentFxObjectPropertyProperty().get().departmentBranchProperty().bind(this.departmentBranchComboBox.valueProperty());

        //TODO: uzuelnic obowiazkowe pola formularza
        this.addDepartmentButton.disableProperty().bind(this.departmentName.textProperty().isEmpty());
        //wyswietlanie
        this.departmentTableView.setItems(this.departmentService.getDepartmentFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.departmentNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.departmentMinNumberOfEmployeesColumn.setCellValueFactory(cellData -> cellData.getValue().minNumberOfEmployeesProperty());
        this.departmentMaxNumberOfEmployeesColumn.setCellValueFactory(cellData -> cellData.getValue().maxNumberOfEmployeesProperty());

        this.departmentManagerColumn.setCellValueFactory(cellData -> cellData.getValue().departmentManagerProperty());
        this.departmentBranchColumn.setCellValueFactory(cellData -> cellData.getValue().departmentBranchProperty());



        //edytowanie
        this.departmentNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.departmentMinNumberOfEmployeesColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.departmentMaxNumberOfEmployeesColumn.setCellFactory(TextFieldTableCell.forTableColumn());


        //zaznaczony wiersz
        this.departmentTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.departmentService.setDepartmentFxObjectPropertyUpdate(newValue);
        });
    }

    //obsluga przycisku do zapisu
    @FXML
    public void addDepartmentOnAction() {
        System.out.println("Wcisnieto przycisk");
        try {
            this.departmentService.saveDepartmentInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listDepartments();
    }

    public void listDepartments() {
        try {
            this.departmentService.listDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //edycja konkretnych kolumn
    @FXML
    public void onEditCommitDepartmentName(TableColumn.CellEditEvent<DepartmentFx, String> departmentFxStringCellEditEvent) {
        this.departmentService.getDepartmentFxObjectPropertyUpdate().setName(departmentFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitDepartmentMaxNumberOfEmployees(TableColumn.CellEditEvent<DepartmentFx, String> departmentFxStringCellEditEvent) {
        this.departmentService.getDepartmentFxObjectPropertyUpdate().setMaxNumberOfEmployees(Integer.parseInt(departmentFxStringCellEditEvent.getNewValue()));
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitDepartmentMinNumberOfEmployees(TableColumn.CellEditEvent<DepartmentFx, String> departmentFxStringCellEditEvent) {
        this.departmentService.getDepartmentFxObjectPropertyUpdate().setMinNumberOfEmployees(Integer.parseInt(departmentFxStringCellEditEvent.getNewValue()));
//        this.departmentService.getDepartmentFxObjectPropertyUpdate().setLastName(departmentFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }



    private void updateInDatabase() {
        try {
            System.out.println("department controller");
            this.departmentService.updateDepartmentInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listDepartments();
    }

    @FXML
    public void deleteDepartmentOnAction() {
        try {
            this.departmentService.deleteDepartmentInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listDepartments();
    }


}