package controllers;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ClientService;

public class ClientController {
    @FXML
    private TextField clientFirstName;

    @FXML
    private TextField clientLastName;

    @FXML
    private Button addClientButton;

    private ClientService clientService;

    public void initialize() {
        this.clientService = new ClientService();
//        StringProperty name = this.clientFirstName.textProperty();
        this.clientService.clientFxObjectPropertyProperty().get().firstNameProperty().bind(this.clientFirstName.textProperty());
        this.clientService.clientFxObjectPropertyProperty().get().lastNameProperty().bind(this.clientLastName.textProperty());
    }

    @FXML
    public void addClientOnAction() {
        System.out.println("Wcisnieto przycisk");
        this.clientService.saveClientInDatabase();
    }
}
