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

//        dodawanie
        this.clientService.clientFxObjectPropertyProperty().get().firstNameProperty().bind(this.clientFirstName.textProperty());
        this.clientService.clientFxObjectPropertyProperty().get().lastNameProperty().bind(this.clientLastName.textProperty());
        this.addClientButton.disableProperty().bind(this.clientFirstName.textProperty().isEmpty().or(this.clientLastName.textProperty().isEmpty()));
//wyswietlania
        this.clientTableView.setItems(this.clientService.getClientFxObservableList());
        this.idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        this.listClients();
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

    public void listClients(){
        try {
            this.clientService.listClients();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
