package converters;

import modelsFx.CategoryFx;
import modelsDAO.Category;

public class CategoryConverter {
    //zapisujemy bez id
    public static Category convertToCategory(CategoryFx categoryFx) {
        return new Category(categoryFx.getCategoryName());
    }

    //update robimy z id
    public static Category convertToCategoryWithId(CategoryFx categoryFx) {
        return new Category(categoryFx.getId(), categoryFx.getCategoryName());
    }

    public static CategoryFx convertToCategoryFx(Category category) {
        CategoryFx categoryFx = new CategoryFx();
        categoryFx.setId(category.getId());
        categoryFx.setCategoryName(category.getCategoryName());
        return categoryFx;
    }

}
