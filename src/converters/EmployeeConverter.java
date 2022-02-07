package converters;

import modelsDTO.EmployeeDto;
import modelsFx.EmployeeFx;
import modelsDAO.Employee;

public class EmployeeConverter {

    //zapisujemy bez id
    public static Employee convertToEmployee(EmployeeFx employeeFx) {
        return new Employee(employeeFx.getFirstName(), employeeFx.getLastName(), employeeFx.getBonus(),
                employeeFx.getSalary(), convertToEmployeeDto(employeeFx.getEmployeeBoss()),
                JobPositionConverter.convertToJobPositionWithId(employeeFx.getEmployeeJobPosition()),
                DepartmentConverter.convertToDepartmentDto(employeeFx.getEmployeeDepartment()));

    }

    //update robimy z id
    public static Employee convertToEmployeeWithId(EmployeeFx employeeFx) {
        Employee employee = convertToEmployee(employeeFx);
        employee.setId(employeeFx.getId());
        return employee;
    }

    public static EmployeeFx convertToEmployeeFx(Employee employee) {
//        System.out.println(employee + "i jego szef" + employee.getEmployeeBoss());
        EmployeeFx employeeFx = new EmployeeFx();
        employeeFx.setId(employee.getId());
        employeeFx.setFirstName(employee.getFirstName());
        employeeFx.setLastName(employee.getLastName());
        employeeFx.setSalary(employee.getSalary());
        employeeFx.setBonus(employee.getBonus());
        employeeFx.setEmployeeJobPosition(JobPositionConverter.convertToJobPositionFx(employee.getEmployeeJobPosition()));
        if (employee.getEmployeeBoss() != null) {
            employeeFx.setEmployeeBoss(EmployeeConverter.convertToEmployeeFxFromDto(employee.getEmployeeBoss()));
        }

        employeeFx.setEmployeeDepartment(DepartmentConverter.convertToDepartmentFxFromDto(employee.getEmployeeDepartment()));
        return employeeFx;
    }

    public static EmployeeDto convertToEmployeeDto(EmployeeFx employeeFx) {
        return new EmployeeDto(employeeFx.getId(), employeeFx.getFirstName(), employeeFx.getLastName(), employeeFx.getBonus(), employeeFx.getSalary());
    }

    public static EmployeeFx convertToEmployeeFxFromDto(EmployeeDto employee) {

        EmployeeFx employeeFx = new EmployeeFx();
        employeeFx.setId(employee.getId());
        employeeFx.setFirstName(employee.getFirstName());
        employeeFx.setLastName(employee.getLastName());
        employeeFx.setSalary(employee.getSalary());
        employeeFx.setBonus(employee.getBonus());
        return employeeFx;
    }
}

