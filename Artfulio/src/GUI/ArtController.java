/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

 import entities.Artwork;
import services.MyListener;

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
    
    private Artwork artwork;
    private MyListener myListener;
    
    public void Click(MouseEvent mouseEvent){
    myListener.onClickListener(artwork);
    }
    
    public void setData(Artwork artwork, MyListener myListener){
    this.artwork = artwork;
    this.myListener= myListener;
    nameLabel.setText(artwork.getNom_artwork());
    priceLabel.setText(String.valueOf(artwork.getPrix_artwork()));
//    Image image = new Image(getClass().getResourceAsStream(artwork.getImg_artwork()));
//    img.setImage(image);
            }

}
