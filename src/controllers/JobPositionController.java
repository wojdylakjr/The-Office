package controllers;

import fxModels.JobPositionFx;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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



    public void addPositionOnAction() {
    }

    public void onEditCommitName(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void onEditCommitMaxSalary(TableColumn.CellEditEvent cellEditEvent) {
    }

    public void deletePositionOnAction() {
    }
}
