package services;

import database.DataBaseManager;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelsDAO.Product;
import modelsDAO.JobPosition;
import modelsDTO.DepartmentDto;

import modelsFx.ProductRankingFx;
import modelsFx.OrdersViewFx;
import modelsFx.ProductInOrderFx;
import repositories.OrderRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRankingService {
    private ObservableList<ProductRankingFx> productRankingFxObservableList = FXCollections.observableArrayList();
    private ObjectProperty<ProductRankingFx> productRankingFxObjectProperty = new SimpleObjectProperty<>(new ProductRankingFx());

    public ObservableList<ProductRankingFx> getProductRankingFxObservableList() {
        return productRankingFxObservableList;
    }

    public void setProductRankingFxObservableList(ObservableList<ProductRankingFx> productRankingFxObservableList) {
        this.productRankingFxObservableList = productRankingFxObservableList;
    }

    public ProductRankingFx getProductRankingFxObjectProperty() {
        return productRankingFxObjectProperty.get();
    }

    public ObjectProperty<ProductRankingFx> productRankingFxObjectPropertyProperty() {
        return productRankingFxObjectProperty;
    }

    public void setProductRankingFxObjectProperty(ProductRankingFx productRankingFxObjectProperty) {
        this.productRankingFxObjectProperty.set(productRankingFxObjectProperty);
    }

    public void list() throws SQLException {
//        ArrayList<Product> products = new ArrayList<>();
        PreparedStatement statement = DataBaseManager.connection.prepareStatement("select * from ranking_produktow");
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            ProductRankingFx product = new ProductRankingFx(resultSet.getString("nazwa"), resultSet.getInt("ilosc_sprzedanych_sztuk"), resultSet.getInt("przychod_produktu"));

            productRankingFxObservableList.add(product);

        }
        statement.close();
    }
}
