package modelsDAO;

import modelsDTO.EmployeeDto;

import java.sql.Date;
import java.sql.Timestamp;

public class Order {
    private int id;
    Timestamp sqlTimestamp;
    private EmployeeDto employee;
    private Client client;

    public Order() {
        long now = System.currentTimeMillis();
       sqlTimestamp = new Timestamp(now);
        System.out.println(sqlTimestamp);
    }

    public Order(EmployeeDto employee, Client client) {
        this();
        this.employee = employee;
        this.client = client;
    }

    public Order(int id, EmployeeDto employee, Client client) {
        this();
        this.id = id;
        this.employee = employee;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    public void setSqlTimestamp(Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", sqlTimestamp=" + sqlTimestamp +
                ", employee=" + employee.toString() +
                ", client=" + client.toString() +
                '}';
    }
}
