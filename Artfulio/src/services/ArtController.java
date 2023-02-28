/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
 import tn.esprit.artfulio.entites.artwork;

/**
 *
 * @author Asus
 */
public class ArtController {
        @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;
    
    private artwork artwork;
    
    public void setData(artwork artwork){
    this.artwork = artwork;
    nameLabel.setText(artwork.getNom_artwork());
    priceLabel.setText(String.valueOf(artwork.getPrix_artwork()));
//    Image image = new Image(getClass().getResourceAsStream(artwork.getImg_artwork()));
//    img.setImage(image);
            }

}
