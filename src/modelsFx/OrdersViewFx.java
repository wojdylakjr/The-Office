package modelsFx;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.scene.control.ListView;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdersViewFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty dateTime = new SimpleStringProperty();
//    private ObjectProperty<ArrayList<ProductInOrderFx>> productsList = new SimpleObjectProperty<>();
    private ObjectProperty<ListView<ProductInOrderFx>> productList = new SimpleObjectProperty<>();
    private ObjectProperty<ClientFx> client = new SimpleObjectProperty<>();
    private ObjectProperty<EmployeeFx> employee = new SimpleObjectProperty<>();

    public OrdersViewFx() {
    }

    public OrdersViewFx(IntegerProperty id, StringProperty dateTime, ObjectProperty<ListView<ProductInOrderFx>> productList, ObjectProperty<ClientFx> client, ObjectProperty<EmployeeFx> employee) {
        this.id = id;
        this.dateTime = dateTime;
        this.productList = productList;
        this.client = client;
        this.employee = employee;
    }

    public OrdersViewFx(int id, String dateTime, ArrayList<ProductInOrderFx> productList, ClientFx client, EmployeeFx employee) {
        this.id.set(id);
        this.dateTime.setValue(dateTime);
        ListView<ProductInOrderFx> products = new ListView<>();
        products.setPrefHeight(27 * productList.size());
        products.setItems(FXCollections.observableArrayList(productList));
        this.productList.set(products);
        this.client.set(client);
        this.employee.set(employee);
    }
    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getDateTime() {
        return dateTime.get();
    }

    public StringProperty dateTimeProperty() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime.set(dateTime);
    }

//    public ArrayList<ProductInOrderFx> getProductsList() {
//        return productsList.get();
//    }
//
//    public ObjectProperty<ArrayList<ProductInOrderFx>> productsListProperty() {
//        return productsList;
//    }
//
//    public void setProductsList(ArrayList<ProductInOrderFx> productsList) {
//        this.productsList.set(productsList);
//    }


    public ListView<ProductInOrderFx> getProductList() {
        return productList.get();
    }

    public ObjectProperty<ListView<ProductInOrderFx>> productListProperty() {
        return productList;
    }

    public void setProductList(ListView<ProductInOrderFx> productList) {
        this.productList.set(productList);
    }

    public ClientFx getClient() {
        return client.get();
    }

    public ObjectProperty<ClientFx> clientProperty() {
        return client;
    }

    public void setClient(ClientFx client) {
        this.client.set(client);
    }

    public EmployeeFx getEmployee() {
        return employee.get();
    }

    public ObjectProperty<EmployeeFx> employeeProperty() {
        return employee;
    }

    public void setEmployee(EmployeeFx employee) {
        this.employee.set(employee);
    }


}
