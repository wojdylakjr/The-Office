package converters;

import modelsFx.JobPositionFx;
import modelsDAO.JobPosition;

public class JobPositionConverter {
    //zapisujemy bez id
    public static JobPosition convertToJobPosition(JobPositionFx jobPositionFx) {
        return new JobPosition(jobPositionFx.getPositionName(),jobPositionFx.getMinSalary(),jobPositionFx.getMaxSalary());

    }

    //update robimy z id
    public static JobPosition convertToJobPositionWithId(JobPositionFx jobPositionFx) {
        return new JobPosition(jobPositionFx.getId(),jobPositionFx.getPositionName(),jobPositionFx.getMinSalary(),jobPositionFx.getMaxSalary());
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
