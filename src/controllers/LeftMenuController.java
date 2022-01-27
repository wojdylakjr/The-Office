package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class LeftMenuController {

    private MainWindowController mainWindowController;
    private ToggleGroup leftMenu;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    public void getEmployees() {
        System.out.println("1");
    }

    @FXML
    public void getClients() {
        System.out.println("2");
    }

    @FXML
    public void getBranches() {
        System.out.println("3");
    }

    @FXML
    public void getDepartments() {
        System.out.println("4");
    }

    @FXML
    public void getCategories() {
        System.out.println("5");
    }

    @FXML
    public void getProducts() {
        System.out.println("6");
    }
}
