package modelsFx;

import javafx.beans.property.*;
import modelsDAO.Category;

public class ProductFx implements Cloneable {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty name = new SimpleStringProperty();
    private StringProperty price = new SimpleStringProperty();
    private ObjectProperty<CategoryFx> productCategory = new SimpleObjectProperty<>();

    public ProductFx() {
    }

    public ProductFx(String name) {
        this.setName(name);
    }

    public ProductFx(IntegerProperty id, StringProperty name, StringProperty price, ObjectProperty<CategoryFx> productCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public ProductFx(int id, String name, int price, CategoryFx productCategory) {
        this.id.set(id);
        this.setName(name);
        this.setPrice(price);
        this.setProductCategory(productCategory);
    }

    public int getId() {
        return (id.get());
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    @Override
    public ProductFx clone() throws CloneNotSupportedException {
        return (ProductFx) super.clone();

    }

    @Override
    public String toString() {
        return name.get() + " - " + productCategory.get();
    }
}
