package modelsFx;

import javafx.beans.property.*;
import repositories.ProductRepository;

public class ProductInOrderFx implements Cloneable {
    private StringProperty quantity = new SimpleStringProperty();
    private ObjectProperty<ProductFx> product = new SimpleObjectProperty<>();

    public ProductInOrderFx() {
    }

    public ProductInOrderFx(ProductInOrderFx product) throws CloneNotSupportedException {
        this.quantity.setValue(product.getQuantity());
        ProductFx newProduct = new ProductFx(product.getProduct().getId(), product.getProduct().getName(), product.getProduct().getPrice(), product.getProduct().getProductCategory());
        this.productProperty().set(newProduct);
//        this.product.get().setId(product.getProduct().getId());
//        this.product.get().setName(product.getProduct().getName());
//        this.product.get().setPrice(product.getProduct().getPrice());
//        this.product.get().setProductCategory(product.getProduct().getProductCategory());


    }
    public ProductInOrderFx(StringProperty quantity, ObjectProperty<ProductFx> product) {
        this.quantity = quantity;
        this.product = product;
    }

    public String getQuantity() {
        return quantity.get();
    }

    public StringProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity.set(quantity);
    }

    public ProductFx getProduct() {
        return product.get();
    }

    public ObjectProperty<ProductFx> productProperty() {
        return product;
    }

    public void setProduct(ProductFx product) {
        this.product.set(product);
    }

//    @Override
//    public ProductInOrderFx clone() throws CloneNotSupportedException {
//        ProductInOrderFx clone = (ProductInOrderFx) super.clone();
////        clone.productProperty() = (ProductFx)this.product.clone();
//
//        return clone;
//    }

    @Override
    public String toString() {
        return "ProductInOrderFx{" +
                "quantity=" + quantity.get() +
                ", product=" + product.get() +
                '}';
    }
}
