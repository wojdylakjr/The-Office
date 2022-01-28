package converters;

import fxModels.DepartmentFx;
import models.Department;

public class DepartmentConverter {

    //zapisujemy bez id
    public static Department convertToDepartment(DepartmentFx departmentFx) {
        Department department = new Department();
//        department.setName(departmentFx.getName());
//        department.setPrice(departmentFx.getPrice());
//        department.setDepartmentCategory(CategoryConverter.convertToCategoryWithId(departmentFx.getDepartmentCategory()));
        return department;
    }

    //update robimy z id
    public static Department convertToDepartmentWithId(DepartmentFx departmentFx) {
        Department department = new Department();
//        department.setId(departmentFx.getId());
//        department.setName(departmentFx.getName());
//        department.setPrice(departmentFx.getPrice());
//        department.setDepartmentCategory(CategoryConverter.convertToCategoryWithId(departmentFx.getDepartmentCategory()));
        return department;
    }

    public static DepartmentFx convertToDepartmentFx(Department department) {
        DepartmentFx departmentFx = new DepartmentFx();
//        departmentFx.setId(department.getId());
//        departmentFx.setName(department.getName());
//        departmentFx.setPrice(department.getPrice());
//        departmentFx.setDepartmentCategory(CategoryConverter.convertToCategoryFx(department.getDepartmentCategory()));
        return departmentFx;
    }


}
