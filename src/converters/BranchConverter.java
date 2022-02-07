package converters;

import modelsDTO.BranchDto;
import modelsFx.BranchFx;
import modelsDAO.Branch;

public class BranchConverter {

    //zapisujemy bez id
    public static Branch convertToBranch(BranchFx branchFx) {
        return new Branch(branchFx.getCityName(), EmployeeConverter.convertToEmployeeDto(branchFx.getBranchDirector()));
    }

    //update robimy z id
    public static Branch convertToBranchWithId(BranchFx branchFx) {
        return new Branch(branchFx.getId(), branchFx.getCityName(), EmployeeConverter.convertToEmployeeDto(branchFx.getBranchDirector()));
    }

    public static BranchFx convertToBranchFx(Branch branch) {
        BranchFx branchFx = new BranchFx();
        branchFx.setId(branch.getId());
        branchFx.setCityName(branch.getCityName());
        branchFx.setBranchDirector(EmployeeConverter.convertToEmployeeFxFromDto(branch.getBranchDirector()));
        return branchFx;
    }


    public static BranchFx convertToBranchFxFromDto(BranchDto branch) {
        BranchFx branchFx = new BranchFx();
        branchFx.setId(branch.getId());
        branchFx.setCityName(branch.getCityName());
        return branchFx;
    }

    public static BranchDto convertToBranchDto(BranchFx departmentBranchFx) {
        return new BranchDto(departmentBranchFx.getId(), departmentBranchFx.getCityName());
    }
}
