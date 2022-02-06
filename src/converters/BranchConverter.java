package converters;

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


}
