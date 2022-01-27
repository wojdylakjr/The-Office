package converters;

import fxModels.CategoryFx;
import fxModels.ClientFx;
import models.Category;
import models.Client;

public class CategoryConverter {
    //zapisujemy bez id
    public static Category convertToCategory(CategoryFx categoryFx) {
        Category category = new Category();
        category.setCategoryName(categoryFx.getCategoryName());
        return category;
    }

    //update robimy z id
    public static Category convertToCategoryWithId(CategoryFx categoryFx) {
        Category category = new Category();
        category.setId(categoryFx.getId());
        category.setCategoryName(categoryFx.getCategoryName());
        return category;
    }

    public static CategoryFx convertToCategoryFx(Category category) {
        CategoryFx categoryFx = new CategoryFx();
        categoryFx.setId(category.getId());
        categoryFx.setCategoryName(category.getCategoryName());
        return categoryFx;
    }

}
