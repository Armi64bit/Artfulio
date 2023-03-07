package tn.esprit.artfulio.gui;

import tn.esprit.artfulio.entites.artwork;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleFloatProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CartController implements Initializable {

    @FXML
    private TableView<artwork> cartTable;

    @FXML
    private TableColumn<artwork, String> nameColumn;

    @FXML
    private TableColumn<artwork, Float> priceColumn;
    @FXML
    private Button removeButton;

    @FXML
    private Label TotPrice;

    @FXML
    private Button ConfirmOrder;

    private float totalPrice = 0;
    @FXML
    private AnchorPane rootPane;

  @FXML
private void handleConfirmOrderButton(ActionEvent event) {
    try {
        Parent parent = FXMLLoader.load(getClass().getResource("../GUI/Confirmation.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Order Form");
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
        // Handle the exception here
    }
}

    private void handleRemoveButton(ActionEvent event) {
        // Get the selected item from the table
        artwork selectedItem = cartTable.getSelectionModel().getSelectedItem();

        if (selectedItem != null) {
            // Remove the selected item from the cart
            StoreController.Items.remove(selectedItem);

            // Subtract the removed item's price from the total price
            totalPrice -= selectedItem.getPrix_artwork();

            // Update the total price label
            TotPrice.setText(String.format("%.2f", totalPrice));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Set up the columns in the table
        nameColumn.setCellValueFactory(new PropertyValueFactory<artwork, String>("nom_artwork"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("prix_artwork"));

        // Populate the table with the items in the cart
        cartTable.setItems(StoreController.Items);

        // Calculate the total price of all items in the cart
        for (artwork item : StoreController.Items) {
            totalPrice += item.getPrix_artwork();
        }

        TotPrice.setText(String.format("%.2f", totalPrice));
        // Add event handler for remove button
        removeButton.setOnAction(this::handleRemoveButton);
        
    }
}
