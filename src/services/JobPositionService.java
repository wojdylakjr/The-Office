package services;

import converters.ClientConverter;
import converters.JobPositionConverter;
import fxModels.JobPositionFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.Client;
import models.JobPosition;
import repositories.JobPositionRepository;

import java.sql.SQLException;
import java.util.List;

public class JobPositionService {
    private JobPositionRepository jobPositionRepository = new JobPositionRepository();
    private ObjectProperty<JobPositionFx> jobPositionFxSimpleObjectProperty = new SimpleObjectProperty<>(new JobPositionFx());
    private ObjectProperty<JobPositionFx> jobPositionFxSimpleObjectPropertyUpdate = new SimpleObjectProperty<>(new JobPositionFx());
    private ObservableList<JobPositionFx> JobPositionFxObservableList = FXCollections.observableArrayList();

    //automatyczne getery i setery


    public JobPositionRepository getJobPositionRepository() {
        return jobPositionRepository;
    }

    public void setJobPositionRepository(JobPositionRepository jobPositionRepository) {
        this.jobPositionRepository = jobPositionRepository;
    }

    public JobPositionFx getJobPositionFxSimpleObjectProperty() {
        return jobPositionFxSimpleObjectProperty.get();
    }

    public ObjectProperty<JobPositionFx> jobPositionFxSimpleObjectPropertyProperty() {
        return jobPositionFxSimpleObjectProperty;
    }

    public void setJobPositionFxSimpleObjectProperty(JobPositionFx jobPositionFxSimpleObjectProperty) {
        this.jobPositionFxSimpleObjectProperty.set(jobPositionFxSimpleObjectProperty);
    }

    public JobPositionFx getJobPositionFxSimpleObjectPropertyUpdate() {
        return jobPositionFxSimpleObjectPropertyUpdate.get();
    }

    public ObjectProperty<JobPositionFx> jobPositionFxSimpleObjectPropertyUpdateProperty() {
        return jobPositionFxSimpleObjectPropertyUpdate;
    }

    public void setJobPositionFxSimpleObjectPropertyUpdate(JobPositionFx jobPositionFxSimpleObjectPropertyUpdate) {
        this.jobPositionFxSimpleObjectPropertyUpdate.set(jobPositionFxSimpleObjectPropertyUpdate);
    }

    public ObservableList<JobPositionFx> getJobPositionFxObservableList() {
        return JobPositionFxObservableList;
    }

    public void setJobPositionFxObservableList(ObservableList<JobPositionFx> jobPositionFxObservableList) {
        JobPositionFxObservableList = jobPositionFxObservableList;
    }

    //CRUD
    public void saveJobPositionInDatabase() throws SQLException {
        JobPosition jobPosition = JobPositionConverter.convertToJobPosition(this.getJobPositionFxSimpleObjectProperty());
        jobPositionRepository.save(jobPosition);
    }

    public void listJobPositions() throws SQLException {
        List<JobPosition> positions = jobPositionRepository.getListOfObjects();
        this.JobPositionFxObservableList.clear();
        for (JobPosition position : positions) {
            this.JobPositionFxObservableList.add(JobPositionConverter.convertToJobPositionFx(position));
        }
    }

    public void updateJobPositionInDatabase() throws SQLException {
//        System.out.println(this.getJobPositionFxSimpleObjectPropertyUpdate());
        JobPosition position = JobPositionConverter.convertToJobPositionWithId(this.getJobPositionFxSimpleObjectPropertyUpdate());
//        System.out.println(position);
        jobPositionRepository.update(position);
    }

    public void deleteJobPositionInDatabase() throws SQLException {
        jobPositionRepository.delete(this.getJobPositionFxSimpleObjectPropertyUpdate().getId());
    }
}
