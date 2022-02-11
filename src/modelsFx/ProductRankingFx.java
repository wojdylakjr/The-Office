package modelsFx;

import javafx.beans.property.*;
import javafx.scene.control.ListView;
import modelsDAO.Product;

public class ProductRankingFx {
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty quantity = new SimpleIntegerProperty();
    private IntegerProperty income = new SimpleIntegerProperty();

    public ProductRankingFx() {

    }

    public ProductRankingFx(String name, int quantity, int income) {
        this.name.setValue(name);
        this.quantity.setValue(quantity);
        this.income.set(income);
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

    public int getQuantity() {
        return quantity.get();
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public int getIncome() {
        return income.get();
    }

    public IntegerProperty incomeProperty() {
        return income;
    }

    public void setIncome(int income) {
        this.income.set(income);
    }
}
