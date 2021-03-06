package services;

import converters.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.*;
import modelsFx.*;
import repositories.ClientRepository;
import repositories.EmployeeRepository;
import repositories.OrderRepository;
import repositories.ProductRepository;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddOrderService {
    private List<ProductInOrderFx> productInOrderFxArrayList = new ArrayList<>();
    private ObservableList<ProductInOrderFx> productsInOrderFxObservableList = FXCollections.observableArrayList();
    //lista produktow
    private ObjectProperty<ProductInOrderFx> addOrderFxObjectProperty = new SimpleObjectProperty<>(new ProductInOrderFx());
    private ObjectProperty<ProductInOrderFx> addOrderFxObjectPropertyUpdate = new SimpleObjectProperty<>(new ProductInOrderFx());

    //zamowienie
    private ObjectProperty<OrderFx> orderFxObjectProperty = new SimpleObjectProperty<>(new OrderFx());

    private EmployeeRepository employeeRepository = new EmployeeRepository();
    private ClientRepository clientRepository = new ClientRepository();
    private ProductRepository productRepository = new ProductRepository();
    private OrderRepository orderRepository = new OrderRepository();

    //    private ObjectProperty<List<String>> products = new SimpleObjectProperty<>();
    private ObservableList<EmployeeFx> employeeFxObservableList = FXCollections.observableArrayList();
    private ObservableList<ClientFx> clientFxObservableList = FXCollections.observableArrayList();
    private ObservableList<ProductFx> productFxObservableList = FXCollections.observableArrayList();

    public void setProductInOrderFxArrayList(List<ProductInOrderFx> productInOrderFxArrayList) {
        this.productInOrderFxArrayList = productInOrderFxArrayList;
    }

    public OrderFx getOrderFxObjectProperty() {
        return orderFxObjectProperty.get();
    }

    public ObjectProperty<OrderFx> orderFxObjectPropertyProperty() {
        return orderFxObjectProperty;
    }

    public void setOrderFxObjectProperty(OrderFx orderFxObjectProperty) {
        this.orderFxObjectProperty.set(orderFxObjectProperty);
    }

    public List<ProductInOrderFx> getProductInOrderFxArrayList() {
        return productInOrderFxArrayList;
    }

    public ObservableList<ProductInOrderFx> getProductsInOrderFxObservableList() {
        return productsInOrderFxObservableList;
    }

    public void setProductsInOrderFxObservableList(ObservableList<ProductInOrderFx> productsInOrderFxObservableList) {
        this.productsInOrderFxObservableList = productsInOrderFxObservableList;
    }

    public ProductInOrderFx getAddOrderFxObjectProperty() throws CloneNotSupportedException {
        return new ProductInOrderFx(this.addOrderFxObjectProperty.get());
//        return addOrderFxObjectProperty.get();
    }

    public ObjectProperty<ProductInOrderFx> addOrderFxObjectPropertyProperty() {
        return addOrderFxObjectProperty;
    }

    public void setAddOrderFxObjectProperty(ProductInOrderFx addOrderFxObjectProperty) {
        this.addOrderFxObjectProperty.set(addOrderFxObjectProperty);
    }

    public ProductInOrderFx getAddOrderFxObjectPropertyUpdate() {
        return addOrderFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<ProductInOrderFx> addOrderFxObjectPropertyUpdateProperty() {
        return addOrderFxObjectPropertyUpdate;
    }

    public void setAddOrderFxObjectPropertyUpdate(ProductInOrderFx addOrderFxObjectPropertyUpdate) {
        this.addOrderFxObjectPropertyUpdate.set(addOrderFxObjectPropertyUpdate);
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ObservableList<EmployeeFx> getEmployeeFxObservableList() {
        return employeeFxObservableList;
    }

    public void setEmployeeFxObservableList(ObservableList<EmployeeFx> employeeFxObservableList) {
        this.employeeFxObservableList = employeeFxObservableList;
    }

    public ObservableList<ClientFx> getClientFxObservableList() {
        return clientFxObservableList;
    }

    public void setClientFxObservableList(ObservableList<ClientFx> clientFxObservableList) {
        this.clientFxObservableList = clientFxObservableList;
    }

    public ObservableList<ProductFx> getProductFxObservableList() {
        return productFxObservableList;
    }

    public void setProductFxObservableList(ObservableList<ProductFx> productFxObservableList) {
        this.productFxObservableList = productFxObservableList;
    }

    public void list() throws SQLException, CloneNotSupportedException {
        this.productsInOrderFxObservableList.clear();
        for (ProductInOrderFx product : productInOrderFxArrayList) {
            productsInOrderFxObservableList.add(product);
        }
    }

    public void init() throws SQLException {
        this.initClientList();
        this.initProductList();
        this.initEmployeeList();
    }


    private void initClientList() throws SQLException {
        List<Client> clients = this.clientRepository.getListOfObjects();
        this.clientFxObservableList.clear();
        for (Client client : clients) {
            this.clientFxObservableList.add(ClientConverter.convertToClientFx(client));
        }
    }

    private void initProductList() throws SQLException {
        List<Product> products = this.productRepository.getListOfObjects();
        this.productFxObservableList.clear();
        for (Product product : products) {
            this.productFxObservableList.add(ProductConverter.convertToProductFx(product));
        }
    }

    private void initEmployeeList() throws SQLException {
        List<Employee> employees = this.employeeRepository.getListOfSellers();
        this.employeeFxObservableList.clear();
        for (Employee employee : employees) {
            this.employeeFxObservableList.add(EmployeeConverter.convertToEmployeeFx(employee));
        }
    }

    public void addProducts() throws CloneNotSupportedException {
        ProductInOrderFx newProduct = new ProductInOrderFx(this.addOrderFxObjectProperty.get());
        if (newProduct.productProperty() != null)
            this.productInOrderFxArrayList.add(newProduct);
    }

    public void addOrder() throws SQLException {
        Order order = OrderConverter.convertToOrder(this.getOrderFxObjectProperty());
        orderRepository.save(order);
        order.setId(orderRepository.getOrderId(order));
        for (ProductInOrderFx product : productInOrderFxArrayList) {
            orderRepository.saveDetailOrder(order, product);
        }
        this.productsInOrderFxObservableList.clear();
    }

    public void delete() {
        ProductInOrderFx addOrderFxObjectProperty = this.getAddOrderFxObjectPropertyUpdate();
        productInOrderFxArrayList.remove(addOrderFxObjectProperty);
    }
}
