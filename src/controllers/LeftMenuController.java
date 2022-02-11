package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

public class LeftMenuController {
    private static final String CLIENT_FXML = "/fxml/Client.fxml";
    private static final String JOB_POSITION_FXML = "/fxml/JobPosition.fxml";
    private static final String CATEGORY_FXML = "/fxml/Category.fxml";
    private static final String PRODUCT_FXML = "/fxml/Product.fxml";
    private static final String EMPLOYEE_FXML = "/fxml/Employee.fxml";
    private static final String BRANCH_FXML = "/fxml/Branch.fxml";
    private static final String DEPARTMENT_FXML = "/fxml/Department.fxml";
    private static final String ADD_ORDER_FXML = "/fxml/AddOrder.fxml";
    private static final String LIST_ORDERS_FXML = "/fxml/OrdersView.fxml";
    private static final String EMPLOYEE_RANKING_FXML = "/fxml/EmployeeRanking.fxml";
    private static final String PRODUCT_RANKING_FXML = "/fxml/ProductRanking.fxml";
    private static final String JOB_POSITION_DETAILS_FXML = "/fxml/JobPositionDetails.fxml";

    private MainWindowController mainWindowController;
    private ToggleGroup leftMenu;

    public void setMainWindowController(MainWindowController mainWindowController) {
        this.mainWindowController = mainWindowController;

    }

    @FXML
    public void getEmployees() {
        mainWindowController.setRight(EMPLOYEE_FXML);
    }

    @FXML
    public void getClients() {
        mainWindowController.setRight(CLIENT_FXML);
    }

    @FXML
    public void getBranches() {
        mainWindowController.setRight(BRANCH_FXML);
    }

    @FXML
    public void getDepartments() {
        mainWindowController.setRight(DEPARTMENT_FXML);
    }

    @FXML
    public void getCategories() {
        mainWindowController.setRight(CATEGORY_FXML);
    }

    @FXML
    public void getProducts() {
        mainWindowController.setRight(PRODUCT_FXML);
    }

    @FXML
    public void getJobPositions() {
        mainWindowController.setRight(JOB_POSITION_FXML);
    }

    @FXML
    public void getEmployeeRanking() {
        mainWindowController.setRight(EMPLOYEE_RANKING_FXML);
    }

    @FXML
    public void getProductRanking() {
        mainWindowController.setRight(PRODUCT_RANKING_FXML);
    }

    @FXML
    public void addOrder() {
        mainWindowController.setRight(ADD_ORDER_FXML);
    }

    @FXML
    public void listOrder() {
        mainWindowController.setRight(LIST_ORDERS_FXML);
    }

    @FXML
    public void getJobPositionDetails() {
        mainWindowController.setRight(JOB_POSITION_DETAILS_FXML);
    }
}
