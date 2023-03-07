/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

 import tn.esprit.artfulio.entites.artwork;
import java.io.File;
import tn.esprit.artfulio.services.MyListener;

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
    private MyListener myListener;
    
    public void Click(MouseEvent mouseEvent){
    myListener.onClickListener(artwork);
    }
    public void setImage(String imagePath) {
    File file = new File(imagePath);
    Image image = new Image(file.toURI().toString());
    img.setImage(image);
}
    public void setData(artwork artwork, MyListener myListener){
    this.artwork = artwork;
    this.myListener= myListener;
    nameLabel.setText(artwork.getNom_artwork());
    priceLabel.setText(String.valueOf(artwork.getPrix_artwork()));
    setImage(artwork.getImg_artwork());

}}
