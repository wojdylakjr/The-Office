package converters;

import modelsDTO.DepartmentDto;
import modelsFx.DepartmentFx;
import modelsDAO.Department;

public class DepartmentConverter {

    //zapisujemy bez id
    public static Department convertToDepartment(DepartmentFx departmentFx) {
        Department department = new Department();
        department.setName(departmentFx.getName());
        department.setMaxNumberOfEmployees(departmentFx.getMaxNumberOfEmployees());
        department.setMinNumberOfEmployees(departmentFx.getMinNumberOfEmployees());
        department.setDepartmentBranch(BranchConverter.convertToBranchWithId(departmentFx.getDepartmentBranch()));
        department.setDepartmentManager(EmployeeConverter.convertToEmployeeWithId(departmentFx.getDepartmentManager()));

        return department;
    }

    //update robimy z id
    public static Department convertToDepartmentWithId(DepartmentFx departmentFx) {
        Department department = new Department();
        department.setId(departmentFx.getId());
        department.setName(departmentFx.getName());
        department.setMaxNumberOfEmployees(departmentFx.getMaxNumberOfEmployees());
        department.setMinNumberOfEmployees(departmentFx.getMinNumberOfEmployees());
        department.setDepartmentBranch(BranchConverter.convertToBranchWithId(departmentFx.getDepartmentBranch()));
        department.setDepartmentManager(EmployeeConverter.convertToEmployeeWithId(departmentFx.getDepartmentManager()));
        return department;
    }

    public static DepartmentFx convertToDepartmentFx(Department department) {

        DepartmentFx departmentFx = new DepartmentFx();
        departmentFx.setId(department.getId());
        departmentFx.setName(department.getName());
        departmentFx.setMaxNumberOfEmployees(department.getMaxNumberOfEmployees());
        departmentFx.setMinNumberOfEmployees(department.getMinNumberOfEmployees());
        departmentFx.setDepartmentManager(EmployeeConverter.convertToEmployeeFx(department.getDepartmentManager()));
        departmentFx.setDepartmentBranch(BranchConverter.convertToBranchFx(department.getDepartmentBranch()));
        return departmentFx;
    }

    public static DepartmentDto convertToDepartmentDto(DepartmentFx employeeDepartment) {
        return new DepartmentDto(employeeDepartment.getId(), employeeDepartment.getName(), employeeDepartment.getMaxNumberOfEmployees(), employeeDepartment.getMinNumberOfEmployees());
    }

    public static DepartmentFx convertToDepartmentFxFromDto(DepartmentDto department) {
        DepartmentFx departmentFx = new DepartmentFx();
        departmentFx.setId(department.getId());
        departmentFx.setName(department.getName());
        departmentFx.setMaxNumberOfEmployees(department.getMaxNumberOfEmployees());
        departmentFx.setMinNumberOfEmployees(department.getMinNumberOfEmployees());
        return departmentFx;
    }
}

