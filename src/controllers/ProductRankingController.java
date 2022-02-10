package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelsFx.ProductRankingFx;
import services.ProductRankingService;

import java.sql.SQLException;

public class ProductRankingController {
    @FXML
    public TableView<ProductRankingFx> productRankingTableView;
    @FXML
    public TableColumn<ProductRankingFx, String> productColumn;
    @FXML
    public TableColumn<ProductRankingFx, Number> quantityColumn;
    @FXML
    public TableColumn<ProductRankingFx, Number> incomeColumn;

    private ProductRankingService productRankingService;

    public void initialize(){
        productRankingService = new ProductRankingService();
        this.list();

        this.productRankingTableView.setItems(this.productRankingService.getProductRankingFxObservableList());
        this.productColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.quantityColumn.setCellValueFactory(cellData -> cellData.getValue().quantityProperty());
        this.incomeColumn.setCellValueFactory(cellData -> cellData.getValue().incomeProperty());
    }

    private void list() {
        try {
            this.productRankingService.list();
        } catch (SQLException e) {
            Alert a1 = new Alert(Alert.AlertType.ERROR, e.getMessage(), ButtonType.OK);
            a1.show();
            e.printStackTrace();
        }
    }
}
