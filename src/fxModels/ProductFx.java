package fxModels;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductFx {
    private StringProperty id = new SimpleStringProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty price = new SimpleStringProperty();
    private ObjectProperty<CategoryFx> productCategory = new SimpleObjectProperty<>();

    public int getId() {
        return Integer.parseInt(id.get());
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(String.valueOf(id));
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getPrice() {
        return Integer.parseInt(price.get());
    }

    public StringProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(String.valueOf(price));
    }

    public CategoryFx getProductCategory() {
        return productCategory.get();
    }

    public ObjectProperty<CategoryFx> productCategoryProperty() {
        return productCategory;
    }

    public void setProductCategory(CategoryFx productCategory) {
        this.productCategory.set(productCategory);
    }
}
