package converters;

import fxModels.BranchFx;
import models.Branch;

public class BranchConverter {

    //zapisujemy bez id
    public static Branch convertToBranch(BranchFx branchFx) {
        Branch branch = new Branch();
        branch.setCityName(branchFx.getCityName());
        branch.setBranchManager(EmployeeConverter.convertToEmployeeWithId(branchFx.getBranchManager()));
        return branch;
    }

    //update robimy z id
    public static Branch convertToBranchWithId(BranchFx branchFx) {
        Branch branch = new Branch();
        branch.setId(branchFx.getId());
        branch.setCityName(branchFx.getCityName());
        branch.setBranchManager(EmployeeConverter.convertToEmployeeWithId(branchFx.getBranchManager()));
        return branch;
    }

    public static BranchFx convertToBranchFx(Branch branch) {
        BranchFx branchFx = new BranchFx();
        branchFx.setId(branch.getId());
        branchFx.setCityName(branch.getCityName());
        branchFx.setBranchManager(EmployeeConverter.convertToEmployeeFx(branch.getBranchManager()));
        return branchFx;
    }


}
