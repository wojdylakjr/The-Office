package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class LeftMenuController {
    private static final String CLIENT_FXML = "/fxml/Client.fxml";
    private static final String JOB_POSITION_FXML = "/fxml/JobPosition.fxml";
    private static final String CATEGORY_FXML = "/fxml/Category.fxml";
    private static final String PRODUCT_FXML = "/fxml/Product.fxml";
    private static final String EMPLOYEE_FXML = "/fxml/Employee.fxml";

    private MainWindowController mainWindowController;
    private ToggleGroup leftMenu;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;
    }

    @FXML
    public void getEmployees() {
        System.out.println("1");
        mainWindowController.setRight(EMPLOYEE_FXML);
    }

    @FXML
    public void getClients() {
        System.out.println("2");
        mainWindowController.setRight(CLIENT_FXML);
//        mainWindowController.se
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
        mainWindowController.setRight(CATEGORY_FXML);
    }

    @FXML
    public void getProducts() {
        System.out.println("6");
        mainWindowController.setRight(PRODUCT_FXML);
    }

    @FXML
    public void getJobPositions() {
        System.out.println("7");
        mainWindowController.setRight(JOB_POSITION_FXML);
    }
}
