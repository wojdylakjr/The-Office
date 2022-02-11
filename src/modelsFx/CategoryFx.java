package modelsFx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import modelsDAO.Category;

public class CategoryFx implements Cloneable {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty categoryName = new SimpleStringProperty();

    public CategoryFx() {
    }

    public CategoryFx(IntegerProperty id, StringProperty categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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
    public CategoryFx clone() throws CloneNotSupportedException {
        return (CategoryFx) super.clone();

    }

    @Override
    public String toString() {
        return "" + categoryName.get();
    }
}
