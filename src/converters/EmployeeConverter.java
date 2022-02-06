package converters;

import modelsDTO.EmployeeDto;
import modelsFx.EmployeeFx;
import modelsDAO.Employee;

public class EmployeeConverter {

    //zapisujemy bez id
    public static Employee convertToEmployee(EmployeeFx employeeFx) {
        Employee employee = new Employee();
        employee.setFirstName(employeeFx.getFirstName());
        employee.setLastName(employeeFx.getLastName());
        employee.setSalary(employeeFx.getSalary());
        employee.setBonus(employeeFx.getBonus());
        employee.setEmployeeJobPosition(JobPositionConverter.convertToJobPositionWithId(employeeFx.getEmployeeJobPosition()));

        //w szefie podamy tylko jego id i zaciagniemy go z bazy
        employee.setEmployeeBoss(convertToEmployeeDto(employeeFx));
        employee.setEmployeeDepartment(DepartmentConverter.convertToDepartmentDto(employeeFx.getEmployeeDepartment()));


//        employee.setEmployeeBoss(EmployeeConverter.convertToEmployeeWithId(employeeFx.getEmployeeBoss()));
//        employee.setEmployeeBossID(EmployeeConverter.convertToEmployeeWithId(employeeFx.getEmployeeBoss()));

        return employee;
    }

    //update robimy z id
    public static Employee convertToEmployeeWithId(EmployeeFx employeeFx) {
        Employee employee = new Employee();
        employee.setId(employeeFx.getId());
        employee.setFirstName(employeeFx.getFirstName());
        employee.setLastName(employeeFx.getLastName());
        employee.setSalary(employeeFx.getSalary());
        employee.setBonus(employeeFx.getBonus());
        employee.setEmployeeJobPosition(JobPositionConverter.convertToJobPositionWithId(employeeFx.getEmployeeJobPosition()));
        employee.setEmployeeBoss(convertToEmployeeDto(employeeFx));
        employee.setEmployeeDepartment(DepartmentConverter.convertToDepartmentDto(employeeFx.getEmployeeDepartment()));
        return employee;
    }

    public static EmployeeFx convertToEmployeeFx(Employee employee) {
        System.out.println(employee + "i jego szef" + employee.getEmployeeBoss());
        EmployeeFx employeeFx = new EmployeeFx();
        employeeFx.setId(employee.getId());
        employeeFx.setFirstName(employee.getFirstName());
        employeeFx.setLastName(employee.getLastName());
        employeeFx.setSalary(employee.getSalary());
        employeeFx.setBonus(employee.getBonus());
        employeeFx.setEmployeeJobPosition(JobPositionConverter.convertToJobPositionFx(employee.getEmployeeJobPosition()));
        if(employee.getEmployeeBoss() != null){
            employeeFx.setEmployeeBoss(EmployeeConverter.convertToEmployeeFxFromDto(employee.getEmployeeBoss()));
        }

        employeeFx.setEmployeeDepartment(DepartmentConverter.convertToDepartmentFxFromDto(employee.getEmployeeDepartment()));
        return employeeFx;
    }

    public static EmployeeDto convertToEmployeeDto(EmployeeFx employeeFx) {
        return new EmployeeDto(employeeFx.getId(), employeeFx.getFirstName(),employeeFx.getLastName(),employeeFx.getBonus(),employeeFx.getSalary());
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

