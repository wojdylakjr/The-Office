package fxModels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.Employee;

public class BranchFx {
    private StringProperty id = new SimpleStringProperty();
    private StringProperty cityName = new SimpleStringProperty();
    private ObjectProperty<EmployeeFx> branchDirector = new SimpleObjectProperty<>();

    public int getId() {
        return Integer.parseInt(id.get());
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(String.valueOf(id));
    }

    public String getCityName() {
        return cityName.get();
    }

    public StringProperty cityNameProperty() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName.set(cityName);
    }

    public EmployeeFx getBranchDirector() {
        return branchDirector.get();
    }

    public ObjectProperty<EmployeeFx> branchDirectorProperty() {
        return branchDirector;
    }

    public void setBranchDirector(EmployeeFx branchDirector) {
        this.branchDirector.set(branchDirector);
    }
}
