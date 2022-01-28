package converters;

        import fxModels.ProductFx;
        import models.Product;

public class ProductConverter {

    //zapisujemy bez id
    public static Product convertToProduct(ProductFx productFx) {
        Product product = new Product();
        product.setName(productFx.getName());
        product.setPrice(productFx.getPrice());
        product.setProductCategory(CategoryConverter.convertToCategoryWithId(productFx.getProductCategory()));
        return product;
    }

    //update robimy z id
    public static Product convertToProductWithId(ProductFx productFx) {
        Product product = new Product();
        product.setId(productFx.getId());
        product.setName(productFx.getName());
        product.setPrice(productFx.getPrice());
        product.setProductCategory(CategoryConverter.convertToCategoryWithId(productFx.getProductCategory()));
        return product;
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
