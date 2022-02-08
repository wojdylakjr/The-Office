package converters;

import modelsDAO.Employee;
import modelsDAO.Order;
import modelsFx.EmployeeFx;
import modelsFx.OrderFx;

public class OrderConverter {
    //zapisujemy bez id
    public static Order convertToOrder(OrderFx orderFx) {
        return new Order(EmployeeConverter.convertToEmployeeDto(orderFx.getEmployee()),ClientConverter.convertToClientWithId(orderFx.getClient()));


    }

    //update robimy z id
    public static Order convertToEmployeeWithId(OrderFx orderFx) {
        Order order = convertToOrder(orderFx);
        order.setId(orderFx.getId());
        return order;
    }

    public static OrderFx convertToOrderFx(Order order) {
//        System.out.println(employee + "i jego szef" + employee.getEmployeeBoss());
        OrderFx orderFx = new OrderFx();
        orderFx.setId(order.getId());
        orderFx.setClient(ClientConverter.convertToClientFx(order.getClient()));
        orderFx.setEmployee(EmployeeConverter.convertToEmployeeFxFromDto(order.getEmployee()));
        return orderFx;
    }
}
