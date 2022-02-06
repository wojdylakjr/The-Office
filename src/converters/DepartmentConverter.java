package converters;

import modelsDTO.DepartmentDto;
import modelsFx.DepartmentFx;
import modelsDAO.Department;

public class DepartmentConverter {

    //zapisujemy bez id
    public static Department convertToDepartment(DepartmentFx departmentFx) {
        return new Department(departmentFx.getName(), departmentFx.getMaxNumberOfEmployees(),departmentFx.getMinNumberOfEmployees(),EmployeeConverter.convertToEmployeeWithId(departmentFx.getDepartmentManager()),BranchConverter.convertToBranchWithId(departmentFx.getDepartmentBranch()));
    }

    //update robimy z id
    public static Department convertToDepartmentWithId(DepartmentFx departmentFx) {
        return new Department(departmentFx.getId(),departmentFx.getName(), departmentFx.getMaxNumberOfEmployees(),departmentFx.getMinNumberOfEmployees(),EmployeeConverter.convertToEmployeeWithId(departmentFx.getDepartmentManager()),BranchConverter.convertToBranchWithId(departmentFx.getDepartmentBranch()));

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

