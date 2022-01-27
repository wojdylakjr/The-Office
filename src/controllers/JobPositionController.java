package controllers;

import fxModels.JobPositionFx;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import services.ClientService;
import services.JobPositionService;

import java.sql.SQLException;

public class JobPositionController {

    //dodawanie
    @FXML
    private TextField positionName;

    @FXML
    private TextField minSalary;

    @FXML
    private TextField maxSalary;

    @FXML
    private Button addPositionButton;

    //wyswietlanie i edycja

    @FXML
    private TableView<JobPositionFx> positionTableView;

    @FXML
    private TableColumn<JobPositionFx, String> idColumn;

    @FXML
    private TableColumn<JobPositionFx, String> positionNameColumn;

    @FXML
    private TableColumn<JobPositionFx, String> minSalaryColumn;

    @FXML
    private TableColumn<JobPositionFx, String> maxSalaryColumn;

    //usuwanie
    @FXML
    private MenuItem deleteMenuItem;

    private JobPositionService jobPositionService;

    public void initialize() {
        this.jobPositionService = new JobPositionService();
        this.listClients();
        //dodawanie
        this.jobPositionService.jobPositionFxSimpleObjectPropertyProperty().get().positionNameProperty().bind(this.positionName.textProperty());
        this.jobPositionService.jobPositionFxSimpleObjectPropertyProperty().get().minSalaryProperty().bind(this.minSalary.textProperty());
        this.jobPositionService.jobPositionFxSimpleObjectPropertyProperty().get().maxSalaryProperty().bind(this.maxSalary.textProperty());
        this.addPositionButton.disableProperty().bind(this.positionName.textProperty().isEmpty());
        //wyswietlanie
        this.positionTableView.setItems(this.jobPositionService.getJobPositionFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.positionNameColumn.setCellValueFactory(cellData -> cellData.getValue().positionNameProperty());
        this.minSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().minSalaryProperty());
        this.maxSalaryColumn.setCellValueFactory(cellData -> cellData.getValue().maxSalaryProperty());


        //edytowanie
        this.positionNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.minSalaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.maxSalaryColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        //zaznaczony wiersz
        this.positionTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.jobPositionService.setJobPositionFxSimpleObjectPropertyUpdate(newValue);

        });
    }

    @FXML
    public void addPositionOnAction() {
        System.out.println("Wcisnieto przycisk");
        try {
            this.jobPositionService.saveJobPositionInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listClients();
    }

    public void listClients() {
        try {
            this.jobPositionService.listJobPositions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditCommitName(TableColumn.CellEditEvent<JobPositionFx, String> jobPositionFxStringCellEditEvent) {
        this.jobPositionService.getJobPositionFxSimpleObjectPropertyUpdate().setPositionName(jobPositionFxStringCellEditEvent.getNewValue());
//        this.clientService.getClientFxObjectPropertyUpdate().setLastName(clientFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitMinSalary(TableColumn.CellEditEvent<JobPositionFx, String> jobPositionFxStringCellEditEvent) {
        this.jobPositionService.getJobPositionFxSimpleObjectPropertyUpdate().setMinSalary(Integer.parseInt(jobPositionFxStringCellEditEvent.getNewValue()));
//        this.clientService.getClientFxObjectPropertyUpdate().setLastName(clientFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitMaxSalary(TableColumn.CellEditEvent<JobPositionFx, String> jobPositionFxStringCellEditEvent) {
        this.jobPositionService.getJobPositionFxSimpleObjectPropertyUpdate().setMaxSalary(Integer.parseInt(jobPositionFxStringCellEditEvent.getNewValue()));
//        this.clientService.getClientFxObjectPropertyUpdate().setLastName(clientFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    private void updateInDatabase() {
        try {
            System.out.println("job postion controller");
            this.jobPositionService.updateJobPositionInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listClients();
    }

    @FXML
    public void deletePositionOnAction() {
        try {
            this.jobPositionService.deleteJobPositionInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listClients();
    }

}
