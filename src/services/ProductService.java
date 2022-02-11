package services;

import converters.CategoryConverter;
import converters.ProductConverter;
import modelsFx.CategoryFx;
import modelsFx.ProductFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.Category;
import modelsDAO.Product;
import repositories.CategoryRepository;
import repositories.ProductRepository;

import java.sql.SQLException;
import java.util.List;

public class ProductService {
    private ProductRepository productRepository = new ProductRepository();
    private CategoryRepository categoryRepository = new CategoryRepository();
    private ObjectProperty<ProductFx> productFxObjectProperty = new SimpleObjectProperty<>(new ProductFx());
    private ObjectProperty<ProductFx> productFxObjectPropertyUpdate = new SimpleObjectProperty<>(new ProductFx());
    private ObservableList<ProductFx> productFxObservableList = FXCollections.observableArrayList();
    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();

    //automatyczne getery i setery

    public ObservableList<CategoryFx> getCategoryFxObservableList() {
        return this.categoryFxObservableList;
    }

    public void setCategoryFxObservableList(ObservableList<CategoryFx> categoryFxObservableList) {
        this.categoryFxObservableList = categoryFxObservableList;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductFx getProductFxObjectProperty() {
        return productFxObjectProperty.get();
    }

    public ObjectProperty<ProductFx> productFxObjectPropertyProperty() {
        return productFxObjectProperty;
    }

    public void setProductFxObjectProperty(ProductFx productFxObjectProperty) {
        this.productFxObjectProperty.set(productFxObjectProperty);
    }

    public ProductFx getProductFxObjectPropertyUpdate() {
        return productFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<ProductFx> productFxObjectPropertyUpdateProperty() {
        return productFxObjectPropertyUpdate;
    }

    public void setProductFxObjectPropertyUpdate(ProductFx productFxObjectPropertyUpdate) {
        this.productFxObjectPropertyUpdate.set(productFxObjectPropertyUpdate);
    }

    public ObservableList<ProductFx> getProductFxObservableList() {
        return productFxObservableList;
    }

    public void setProductFxObservableList(ObservableList<ProductFx> productFxObservableList) {
        this.productFxObservableList = productFxObservableList;
    }

    //CRUD
    public void saveProductInDatabase() throws SQLException {
        System.out.println(this.getProductFxObjectProperty());
        Product product = ProductConverter.convertToProduct(this.getProductFxObjectProperty());
        productRepository.save(product);
    }

    public void listProducts() throws SQLException {
        this.initCategoryList();
        List<Product> products = productRepository.getListOfObjects();
        this.productFxObservableList.clear();
        for (Product product : products) {
            this.productFxObservableList.add(ProductConverter.convertToProductFx(product));
        }
    }

    private void initCategoryList() throws SQLException {
        List<Category> categories = categoryRepository.getListOfObjects();
        this.categoryFxObservableList.clear();
        for (Category category : categories) {
            this.categoryFxObservableList.add(CategoryConverter.convertToCategoryFx(category));
        }
    }

    public void updateProductInDatabase() throws SQLException {
        Product product = ProductConverter.convertToProductWithId(this.getProductFxObjectPropertyUpdate());
        productRepository.update(product);
    }

    public void deleteProductInDatabase() throws SQLException {
        productRepository.delete(this.getProductFxObjectPropertyUpdate().getId());
    }
}
