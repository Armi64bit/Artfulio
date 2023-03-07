package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author msi
 */
public class CartController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<?> cartTable;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> priceColumn;
    @FXML
    private Button removeButton;
    @FXML
    private Label TotPrice;
    @FXML
    private Button ConfirmOrder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleConfirmOrderButton(ActionEvent event) {
    }
    
}
