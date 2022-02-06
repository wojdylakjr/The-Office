package modelsFx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CategoryFx {
    private StringProperty id = new SimpleStringProperty();
    private StringProperty categoryName= new SimpleStringProperty();

    public int getId() {
        return Integer.parseInt(id.get());
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(String.valueOf(id));
    }

    public String getCategoryName() {
        return categoryName.get();
    }

    public StringProperty categoryNameProperty() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName.set(categoryName);
    }

    @Override
    public String toString() {
        return categoryName.getValue();
    }
}
