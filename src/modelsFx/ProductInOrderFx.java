package modelsFx;

import javafx.beans.property.*;
import repositories.ProductRepository;

public class ProductInOrderFx implements Cloneable {
    private StringProperty quantity = new SimpleStringProperty();
    private ObjectProperty<ProductFx> product = new SimpleObjectProperty<>();
    private IntegerProperty productPrice = new SimpleIntegerProperty();

    public ProductInOrderFx() {
    }

    public ProductInOrderFx(String productName, String quantity, int price) {
        this.quantity.setValue(quantity);
        this.product.set(new ProductFx(productName));
        this.productPrice.set(price);
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
        if (product.get() != null) {
//            System.out.println(String.format("%1$-30s %2$-30d %3$-30s", product.get().getName(), this.productPrice.getValue(), quantity.getValue()));
            return String.format("%1$-15s %2$-10s %3$-10s %4$s", product.get().getName(), "[" + this.productPrice.getValue() + " zł] x ", quantity.getValue() + "szt.", " = " + Integer.parseInt(quantity.getValue()) * productPrice.getValue() + " zł");
        }
        return "Brak";
    }
}
