package modelsFx;

import javafx.beans.property.*;
import modelsDAO.Client;
import modelsDAO.Employee;

import java.sql.Date;

public class OrderFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private ObjectProperty<ClientFx> client = new SimpleObjectProperty<>();
    private ObjectProperty<EmployeeFx> employee = new SimpleObjectProperty<>();

    public OrderFx() {
    }

    public OrderFx(ObjectProperty<ClientFx> client, ObjectProperty<EmployeeFx> employee) {
        this.client = client;
        this.employee = employee;
    }

    public ClientFx getClient() {
        return client.get();
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
