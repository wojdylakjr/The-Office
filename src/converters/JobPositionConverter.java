package converters;

import fxModels.JobPositionFx;
import models.JobPosition;

public class JobPositionConverter {
    //zapisujemy bez id
    public static JobPosition convertToJobPosition(JobPositionFx jobPositionFx) {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setPositionName(jobPositionFx.getPositionName());
        jobPosition.setMaxSalary(jobPositionFx.getMaxSalary());
        jobPosition.setMinSalary(jobPositionFx.getMinSalary());
        return jobPosition;
    }

    //update robimy z id
    public static JobPosition convertToJobPositionWithId(JobPositionFx jobPositionFx) {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setId(jobPositionFx.getId());
        jobPosition.setPositionName(jobPositionFx.getPositionName());
        jobPosition.setMaxSalary(jobPositionFx.getMaxSalary());
        jobPosition.setMinSalary(jobPositionFx.getMinSalary());
        return jobPosition;
    }

    public static JobPositionFx convertToJobPositionFx(JobPosition jobPosition) {
        JobPositionFx jobPositionFx = new JobPositionFx();
        jobPositionFx.setId(jobPosition.getId());
        jobPositionFx.setPositionName(jobPosition.getPositionName());
        jobPositionFx.setMaxSalary(jobPosition.getMaxSalary());
        jobPositionFx.setMinSalary(jobPosition.getMinSalary());
        return jobPositionFx;
    }
}
