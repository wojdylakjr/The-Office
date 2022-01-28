package converters;

import fxModels.EmployeeFx;
import models.Employee;

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
        employee.setEmployeeBoss(employeeFx.getEmployeeBoss().getId());


//        employee.setEmployeeBoss(EmployeeConverter.convertToEmployeeWithId(employeeFx.getEmployeeBoss()));
//        employee.setEmployeeBossID(EmployeeConverter.convertToEmployeeWithId(employeeFx.getEmployeeBoss()));


//        employee.setEmployeeDepartment(DepartmentConverter.convertToDepartmentWithId(employeeFx.getEmployeeDepartment()));
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
        employee.setEmployeeBoss(employeeFx.getEmployeeBoss().getId());
//        employee.setEmployeeBossID(EmployeeConverter.convertToEmployeeWithId(employeeFx.getEmployeeBoss()));


        employee.setEmployeeDepartment(DepartmentConverter.convertToDepartmentWithId(employeeFx.getEmployeeDepartment()));
        return employee;
    }

    public static EmployeeFx convertToEmployeeFx(Employee employee) {
        EmployeeFx employeeFx = new EmployeeFx();
        employeeFx.setId(employee.getId());
        employeeFx.setFirstName(employee.getFirstName());
        employeeFx.setLastName(employee.getLastName());
        employeeFx.setSalary(employee.getSalary());
        employeeFx.setBonus(employee.getBonus());
        employeeFx.setEmployeeJobPosition(JobPositionConverter.convertToJobPositionFx(employee.getEmployeeJobPosition()));
//        employeeFx.setEmployeeBoss(EmployeeConverter.convertToEmployeeFx(employee.getEmployeeBoss()));
        employeeFx.setEmployeeDepartment(DepartmentConverter.convertToDepartmentFx(employee.getEmployeeDepartment()));
        return employeeFx;
    }

}

