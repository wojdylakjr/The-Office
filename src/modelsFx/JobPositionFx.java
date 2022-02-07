package modelsFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JobPositionFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty positionName = new SimpleStringProperty();
    private StringProperty minSalary = new SimpleStringProperty();
    private StringProperty maxSalary = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getPositionName() {
        return positionName.get();
    }

    public StringProperty positionNameProperty() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName.set(positionName);
    }

    public int getMinSalary() {
        return Integer.parseInt(minSalary.get());
    }

    public StringProperty minSalaryProperty() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary.set(String.valueOf(minSalary));
    }

    public int getMaxSalary() {
        return Integer.parseInt(maxSalary.get());
    }

    public StringProperty maxSalaryProperty() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary.set(String.valueOf(maxSalary));
    }

    @Override
    public String toString() {
        return positionName.getValue();
    }
}