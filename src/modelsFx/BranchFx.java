package modelsFx;

import javafx.beans.property.*;

public class BranchFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty cityName = new SimpleStringProperty();
    private ObjectProperty<EmployeeFx> branchDirector = new SimpleObjectProperty<>();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    @Override
    public String toString() {
        return cityName.get();
    }
}
