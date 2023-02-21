/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author karra
 */
public class DetailsController implements Initializable {

    @FXML
    private TextField resNom;
    @FXML
    private TextField resPrenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public TextField getResNom() {
        return resNom;
    }

    public void setResNom(String message) {
        this.resNom.setText(message);
    }

    public TextField getResPrenom() {
        return resPrenom;
    }

    public void setResPrenom(String message) {
        this.resPrenom.setText(message);
    }
    
}
