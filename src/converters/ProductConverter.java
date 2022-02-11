package converters;

import modelsFx.ProductFx;
import modelsDAO.Product;

public class ProductConverter {

    //zapisujemy bez id
    public static Product convertToProduct(ProductFx productFx) {
        return new Product(productFx.getName(), productFx.getPrice(), CategoryConverter.convertToCategoryWithId(productFx.getProductCategory()));

    }

    //update robimy z id
    public static Product convertToProductWithId(ProductFx productFx) {
        return new Product(productFx.getId(), productFx.getName(), productFx.getPrice(), CategoryConverter.convertToCategoryWithId(productFx.getProductCategory()));
    }

    public static ProductFx convertToProductFx(Product product) {
        ProductFx productFx = new ProductFx();
        productFx.setId(product.getId());
        productFx.setName(product.getName());
        productFx.setPrice(product.getPrice());
        productFx.setProductCategory(CategoryConverter.convertToCategoryFx(product.getProductCategory()));
        return productFx;
    }


}
