package controllers;

import modelsFx.DepartmentFx;
import modelsFx.JobPositionFx;
import modelsFx.EmployeeFx;
import javafx.fxml.FXML;


import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import services.EmployeeService;

import java.sql.SQLException;

public class EmployeeController {
    //dodawanie
    @FXML
    private TextField employeeFirstName;

    @FXML
    private TextField employeeLastName;

    @FXML
    private TextField employeeSalary;

    @FXML
    private TextField employeeBonus;

    @FXML
    private ComboBox<JobPositionFx> employeePositionComboBox;

    @FXML
    private ComboBox<EmployeeFx> employeeBossComboBox;

    @FXML
    private ComboBox<DepartmentFx> employeeDepartmentsComboBox;

    @FXML
    private Button addEmployeeButton;

    //wyswietlanie i edycja

    @FXML
    private TableView<EmployeeFx> employeeTableView;

    @FXML
    private TableColumn<EmployeeFx, String> idColumn;

    @FXML
    private TableColumn<EmployeeFx, String> employeeFirstNameColumn;

    @FXML
    private TableColumn<EmployeeFx, String> employeeLastNameColumn;

    @FXML
    private TableColumn<EmployeeFx, String> employeeSalaryColumn;

    @FXML
    private TableColumn<EmployeeFx, String> employeeBonusColumn;

    @FXML
    private TableColumn<EmployeeFx, JobPositionFx> employeePositionColumn;

    @FXML
    private TableColumn<EmployeeFx, EmployeeFx> employeeBossColumn;

    @FXML
    private TableColumn<EmployeeFx, DepartmentFx> employeeDepartmentColumn;

    //usuwanie
    @FXML
    private MenuItem deleteMenuItem;

    private EmployeeService employeeService;

    public void initialize() {
        this.employeeService = new EmployeeService();
        this.listEmployees();
        //dodanie elementow do combo boxa
//        System.out.println(this.employeeService.getJobPositionFxObservableList());
        this.employeePositionComboBox.setItems(this.employeeService.getJobPositionFxObservableList());
        this.employeeBossComboBox.setItems(this.employeeService.getBossFxObservableList());
        this.employeeDepartmentsComboBox.setItems(this.employeeService.getDepartmentFxObservableList());
        //dodawanie
        this.employeeService.employeeFxObjectPropertyProperty().get().firstNameProperty().bind(this.employeeFirstName.textProperty());
        this.employeeService.employeeFxObjectPropertyProperty().get().lastNameProperty().bind(this.employeeLastName.textProperty());
        this.employeeService.employeeFxObjectPropertyProperty().get().salaryProperty().bind(this.employeeSalary.textProperty());
        this.employeeService.employeeFxObjectPropertyProperty().get().bonusProperty().bind(this.employeeBonus.textProperty());
        this.employeeService.employeeFxObjectPropertyProperty().get().employeeJobPositionProperty().bind(this.employeePositionComboBox.valueProperty());
        this.employeeService.employeeFxObjectPropertyProperty().get().employeeBossProperty().bind(this.employeeBossComboBox.valueProperty());
        this.employeeService.employeeFxObjectPropertyProperty().get().employeeDepartmentProperty().bind(this.employeeDepartmentsComboBox.valueProperty());
        //TODO: uzuelnic obowiazkowe pola formularza
        this.addEmployeeButton.disableProperty().bind(this.employeeFirstName.textProperty().isEmpty().or(this.employeeSalary.textProperty().isEmpty()).or(this.employeePositionComboBox.valueProperty().isNull()));
        //wyswietlanie
        this.employeeTableView.setItems(this.employeeService.getEmployeeFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.employeeFirstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.employeeLastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        this.employeeSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty());
        this.employeeBonusColumn.setCellValueFactory(cellData -> cellData.getValue().bonusProperty());
        this.employeePositionColumn.setCellValueFactory(cellData -> cellData.getValue().employeeJobPositionProperty());
        this.employeeBossColumn.setCellValueFactory(cellData -> cellData.getValue().employeeBossProperty());
        this.employeeDepartmentColumn.setCellValueFactory(cellData -> cellData.getValue().employeeDepartmentProperty());


        //edytowanie
        this.employeeFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.employeeFirstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.employeeSalaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.employeeBonusColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //zaznaczony wiersz
        this.employeeTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.employeeService.setEmployeeFxObjectPropertyUpdate(newValue);
        });
    }

    //obsluga przycisku do zapisu
    @FXML
    public void addEmployeeOnAction() {
//        System.out.println(this.employeeBossColumn);
        System.out.println("Wcisnieto przycisk");
        try {
            this.employeeService.saveEmployeeInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listEmployees();
    }

    public void listEmployees() {
        try {
            this.employeeService.listEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //edycja konkretnych kolumn
    @FXML
    public void onEditCommitEmployeeFirstName(TableColumn.CellEditEvent<EmployeeFx, String> employeeFxStringCellEditEvent) {
        this.employeeService.getEmployeeFxObjectPropertyUpdate().setFirstName(employeeFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitEmployeeLastName(TableColumn.CellEditEvent<EmployeeFx, String> employeeFxStringCellEditEvent) {
        this.employeeService.getEmployeeFxObjectPropertyUpdate().setLastName(employeeFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitEmployeeBonus(TableColumn.CellEditEvent<EmployeeFx, String> employeeFxStringCellEditEvent) {
        this.employeeService.getEmployeeFxObjectPropertyUpdate().setBonus(Integer.parseInt(employeeFxStringCellEditEvent.getNewValue()));
//        this.employeeService.getEmployeeFxObjectPropertyUpdate().setLastName(employeeFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitEmployeeSalary(TableColumn.CellEditEvent<EmployeeFx, String> employeeFxStringCellEditEvent) {
        this.employeeService.getEmployeeFxObjectPropertyUpdate().setSalary(Integer.parseInt(employeeFxStringCellEditEvent.getNewValue()));
//        this.employeeService.getEmployeeFxObjectPropertyUpdate().setLastName(employeeFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    private void updateInDatabase() {
        try {
            System.out.println("employee controller");
            this.employeeService.updateEmployeeInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listEmployees();
    }

    @FXML
    public void deleteEmployeeOnAction() {
        try {
            this.employeeService.deleteEmployeeInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listEmployees();
    }


}