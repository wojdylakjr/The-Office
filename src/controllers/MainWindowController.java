package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MainWindowController {


    @FXML
    private BorderPane mainWindow;
    @FXML
    private LeftMenuController leftMenuController;


    public MainWindowController() {
    }

    @FXML
   void initialize() {
        leftMenuController.setMainWindowController(this);
    }

}
