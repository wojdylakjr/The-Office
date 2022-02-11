package modelsFx;

import javafx.beans.property.*;
import javafx.scene.control.ListView;
import modelsDAO.Employee;

public class EmployeeRankingFx {
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private IntegerProperty income = new SimpleIntegerProperty();
    private IntegerProperty clients = new SimpleIntegerProperty();
    private IntegerProperty orders = new SimpleIntegerProperty();

    public EmployeeRankingFx() {

    }

    public EmployeeRankingFx(String firstName, String lastName, int income) {
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.income.set(income);
    }

    public EmployeeRankingFx(String firstName, String lastName, int income, int clients, int orders) {
        this.firstName.setValue(firstName);
        this.lastName.setValue(lastName);
        this.income.set(income);
        this.clients.set(clients);
        this.orders.set(orders);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public int getIncome() {
        return income.get();
    }

    public IntegerProperty incomeProperty() {
        return income;
    }

    public void setIncome(int income) {
        this.income.set(income);
    }

    public int getClients() {
        return clients.get();
    }

    public IntegerProperty clientsProperty() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients.set(clients);
    }

    public int getOrders() {
        return orders.get();
    }

    public IntegerProperty ordersProperty() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders.set(orders);
    }
}
