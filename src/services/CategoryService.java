package services;

import converters.CategoryConverter;
import modelsFx.CategoryFx;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.Category;
import repositories.CategoryRepository;

import java.sql.SQLException;
import java.util.List;

public class CategoryService {
    private CategoryRepository categoryRepository = new CategoryRepository();
    private ObjectProperty<CategoryFx> categoryFxObjectProperty = new SimpleObjectProperty<>(new CategoryFx());
    private ObjectProperty<CategoryFx> categoryFxObjectPropertyUpdate = new SimpleObjectProperty<>(new CategoryFx());
    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryFx getCategoryFxObjectProperty() {
        return categoryFxObjectProperty.get();
    }

    public ObjectProperty<CategoryFx> categoryFxObjectPropertyProperty() {
        return categoryFxObjectProperty;
    }

    public void setCategoryFxObjectProperty(CategoryFx categoryFxObjectProperty) {
        this.categoryFxObjectProperty.set(categoryFxObjectProperty);
    }

    public CategoryFx getCategoryFxObjectPropertyUpdate() {
        return categoryFxObjectPropertyUpdate.get();
    }

    public ObjectProperty<CategoryFx> categoryFxObjectPropertyUpdateProperty() {
        return categoryFxObjectPropertyUpdate;
    }

    public void setCategoryFxObjectPropertyUpdate(CategoryFx categoryFxObjectPropertyUpdate) {
        this.categoryFxObjectPropertyUpdate.set(categoryFxObjectPropertyUpdate);
    }

    public ObservableList<CategoryFx> getCategoryFxObservableList() {
        return categoryFxObservableList;
    }

    public void setCategoryFxObservableList(ObservableList<CategoryFx> categoryFxObservableList) {
        this.categoryFxObservableList = categoryFxObservableList;
    }

    //CRUD
    public void saveCategoryInDatabase() throws SQLException {
        Category category = CategoryConverter.convertToCategory(this.getCategoryFxObjectProperty());
        categoryRepository.save(category);
    }

    public void listCategories() throws SQLException {
        List<Category> categories = categoryRepository.getListOfObjects();
        this.categoryFxObservableList.clear();
        for (Category category : categories) {
            this.categoryFxObservableList.add(CategoryConverter.convertToCategoryFx(category));
        }
    }

    public void updateCategoryInDatabase() throws SQLException {
        System.out.println(this.getCategoryFxObjectPropertyUpdate());
        Category category = CategoryConverter.convertToCategoryWithId(this.getCategoryFxObjectPropertyUpdate());
        System.out.println(category);
        categoryRepository.update(category);
    }

    public void deleteCategoryInDatabase() throws SQLException {
        categoryRepository.delete(this.getCategoryFxObjectPropertyUpdate().getId());
    }
}
