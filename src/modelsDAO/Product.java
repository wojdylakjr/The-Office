package modelsDAO;

public class Product {
    private int id;
    private String name;
    private int price;
    private Category productCategory;


    public Product(int id, String name, int price, Category productCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(String name, int price, Category productCategory) {
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productCategory=" + productCategory.toString() +
                '}';
    }
}