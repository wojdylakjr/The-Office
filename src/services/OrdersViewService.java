package services;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsFx.*;
import repositories.ClientRepository;
import repositories.EmployeeRepository;
import repositories.OrderRepository;
import repositories.ProductRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersViewService {

    private ObservableList<OrdersViewFx> ordersViewFxObservableList = FXCollections.observableArrayList();
    //widok zamowien
    private ObjectProperty<OrdersViewFx> ordersViewFxObjectProperty = new SimpleObjectProperty<>(new OrdersViewFx());
    private ObjectProperty<OrdersViewFx> ordersViewFxObjectPropertyUpdate = new SimpleObjectProperty<>(new OrdersViewFx());
    private OrderRepository orderRepository = new OrderRepository();

    //lista produktow
    private ObservableList<ProductInOrderFx> productsFxObservableList = FXCollections.observableArrayList();

    public OrdersViewFx getOrdersViewFxObjectPropertyUpdate() {
        return ordersViewFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<OrdersViewFx> ordersViewFxObjectPropertyUpdateProperty() {
        return ordersViewFxObjectPropertyUpdate;
    }

    public void setOrdersViewFxObjectPropertyUpdate(OrdersViewFx ordersViewFxObjectPropertyUpdate) {
        this.ordersViewFxObjectPropertyUpdate.set(ordersViewFxObjectPropertyUpdate);
    }

    public ObservableList<OrdersViewFx> getOrdersViewFxObservableList() {
        return ordersViewFxObservableList;
    }

    public void setOrdersViewFxObservableList(ObservableList<OrdersViewFx> ordersViewFxObservableList) {
        this.ordersViewFxObservableList = ordersViewFxObservableList;
    }

    public OrdersViewFx getOrdersViewFxObjectProperty() {
        return ordersViewFxObjectProperty.get();
    }

    public ObjectProperty<OrdersViewFx> ordersViewFxObjectPropertyProperty() {
        return ordersViewFxObjectProperty;
    }

    public void setOrdersViewFxObjectProperty(OrdersViewFx ordersViewFxObjectProperty) {
        this.ordersViewFxObjectProperty.set(ordersViewFxObjectProperty);
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public ObservableList<ProductInOrderFx> getProductsFxObservableList() {
        return productsFxObservableList;
    }

    public void setProductsFxObservableList(ObservableList<ProductInOrderFx> productsFxObservableList) {
        this.productsFxObservableList = productsFxObservableList;
    }

    public void list() throws SQLException {

        this.orderRepository.getOrders(this.ordersViewFxObservableList);
    }

    public void deleteOrder() throws SQLException {
        System.out.println(this.getOrdersViewFxObjectPropertyUpdate().getId());
        this.orderRepository.delete(this.getOrdersViewFxObjectPropertyUpdate().getId());
    }
}
