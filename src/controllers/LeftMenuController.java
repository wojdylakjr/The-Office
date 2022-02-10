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
        mainWindowController.setRight(BRANCH_FXML);
    }

    @FXML
    public void getDepartments() {
        System.out.println("4");
        mainWindowController.setRight(DEPARTMENT_FXML);
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

    @FXML
    public void getEmployeeRanking() {
//        System.out.println("7");
        mainWindowController.setRight(EMPLOYEE_RANKING_FXML);
    }

    @FXML
    public void getProductRanking() {
//        System.out.println("7");
        mainWindowController.setRight(PRODUCT_RANKING_FXML);
    }

    @FXML
    public void addOrder() {
        mainWindowController.setRight(ADD_ORDER_FXML);
    }

    @FXML
    public void listOrder(ActionEvent actionEvent) {
        mainWindowController.setRight(LIST_ORDERS_FXML);
    }

    @FXML
    public void getJobPositionDetails(ActionEvent actionEvent) {
        mainWindowController.setRight(JOB_POSITION_DETAILS_FXML);
    }
}
