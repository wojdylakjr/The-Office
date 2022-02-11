package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.util.*;

import java.io.IOException;
import java.util.ResourceBundle;

public class MainWindowController {
    private static final String EMPLOYEE_FXML = "/fxml/Employee.fxml";

    @FXML
    private BorderPane mainWindow;
    @FXML
    private LeftMenuController leftMenuController;


    public MainWindowController() {
    }

    @FXML
    void initialize() {
        leftMenuController.setMainWindowController(this);
        this.setRight(EMPLOYEE_FXML);
    }

    public void setRight(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(fxmlPath));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindow.setRight(parent);

    }


}
