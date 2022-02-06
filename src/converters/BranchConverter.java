package converters;

import modelsFx.BranchFx;
import modelsDAO.Branch;

public class BranchConverter {

    //zapisujemy bez id
    public static Branch convertToBranch(BranchFx branchFx) {
        Branch branch = new Branch();
        branch.setCityName(branchFx.getCityName());
        branch.setBranchDirector(EmployeeConverter.convertToEmployeeDto(branchFx.getBranchDirector()));
        return branch;
    }

    //update robimy z id
    public static Branch convertToBranchWithId(BranchFx branchFx) {
        Branch branch = new Branch();
        branch.setId(branchFx.getId());
        branch.setCityName(branchFx.getCityName());
        branch.setBranchDirector(EmployeeConverter.convertToEmployeeDto(branchFx.getBranchDirector()));
        return branch;
    }

    public static BranchFx convertToBranchFx(Branch branch) {
        BranchFx branchFx = new BranchFx();
        branchFx.setId(branch.getId());
        branchFx.setCityName(branch.getCityName());
        branchFx.setBranchDirector(EmployeeConverter.convertToEmployeeFxFromDto(branch.getBranchDirector()));
        return branchFx;
    }


}
