package controllers;

import fxModels.ClientFx;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import models.Client;
import services.ClientService;

import java.sql.SQLException;

public class ClientController {
    @FXML
    private TextField clientFirstName;

    @FXML
    private TextField clientLastName;

    @FXML
    private Button addClientButton;

    @FXML
    private TableView<ClientFx> clientTableView;

    @FXML
    private TableColumn<ClientFx, String> idColumn;

    @FXML
    private TableColumn<ClientFx, String> firstNameColumn;

    @FXML
    private TableColumn<ClientFx, String> lastNameColumn;

    private ClientService clientService;

    public void initialize() {
        this.clientService = new ClientService();
        this.listClients();
        //dodawanie
        this.clientService.clientFxObjectPropertyProperty().get().firstNameProperty().bind(this.clientFirstName.textProperty());
        this.clientService.clientFxObjectPropertyProperty().get().lastNameProperty().bind(this.clientLastName.textProperty());
        this.addClientButton.disableProperty().bind(this.clientFirstName.textProperty().isEmpty().or(this.clientLastName.textProperty().isEmpty()));
        //wyswietlanie
        this.clientTableView.setItems(this.clientService.getClientFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());


        //edytowanie
        this.idColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.lastNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        this.clientTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            this.clientService.setClientFxObjectPropertyUpdate(newValue);
        });
    }

    @FXML
    public void addClientOnAction() {
        System.out.println("Wcisnieto przycisk");
        try {
            this.clientService.saveClientInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.listClients();
    }

    public void listClients() {
        try {
            this.clientService.listClients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onEditCommitFirstName(TableColumn.CellEditEvent<ClientFx, String> clientFxStringCellEditEvent) {
        this.clientService.getClientFxObjectPropertyUpdate().setFirstName(clientFxStringCellEditEvent.getNewValue());
//        this.clientService.getClientFxObjectPropertyUpdate().setLastName(clientFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    @FXML
    public void onEditCommitLastName(TableColumn.CellEditEvent<ClientFx, String> clientFxStringCellEditEvent) {
        this.clientService.getClientFxObjectPropertyUpdate().setFirstName(clientFxStringCellEditEvent.getNewValue());
//        this.clientService.getClientFxObjectPropertyUpdate().setLastName(clientFxStringCellEditEvent.getNewValue());
        this.updateInDatabase();
    }

    private void updateInDatabase() {
        try {
            System.out.println("client controller");
            this.clientService.updateClientInDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
