/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a17.gui;

import edu.connexion3a17.entities.commentaire;
import edu.connexion3a17.services.CommentaireCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.Scene;

/**
 * FXML Controller class
 *
 * @author 21652
 */
public class UserCommentaireController implements Initializable {

    static Connection myconnex = MyConnection.getInstance().getCnx;

    private Scene scene;

    private Parent root;

    @FXML
    private Button btnaff;

    @FXML
    private Button btncre;

    @FXML
    private Button btnger;

    @FXML
    private TableView<commentaire> table0;

    @FXML
    private Button btnacc;

    @FXML
    private Button btncreate;

    @FXML
    private MenuItem btnmof;

    @FXML
    private MenuItem btnsupp;

    @FXML
    private TableColumn<commentaire, String> commentsec;
    
     @FXML
    private TextField txtcom;

    @FXML
    private TableColumn<commentaire, String> datesec;

    @FXML
    private TableColumn<commentaire, String> commentsec0;

    @FXML
    private TableColumn<commentaire, String> datesec0;

    @FXML
    private TableView<commentaire> table;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void switchToComments(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("UserCommentaire.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToAddComment(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("AddCom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchToModifyComment(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("gerecom.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void displaycom(ActionEvent event) {

        List<commentaire> myList = getcommentaire();
        commentsec.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("Commentaires"));
        datesec.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("Date com"));
        table.setItems(myList);

    }

}

    @FXML
    void createcommentaire(ActionEvent event) {

        String Texte = comtext.getText();

        CommentaireCRUD ps = new CommentaireCRUD();
        commentaire c = new commentaire(Texte, Date_com);
        ps.ajouterEntitee(c);
        modlabel.setText("Commentaire ajoutée!");
    }

    @FXML
    void modCommentaire(ActionEvent event) {
        List<commentaire> myList = getcommentaire();
        String Texte = textmodcom.getText();
        CommentaireCRUD ps = new CommentaireCRUD();
        commentaire c = new commentaire(Texte, Date_com);
        ps.Update(c);
        modlabel.setText("Commentaire modifiée!");

    }

    @FXML
    void suppCommentaire(ActionEvent event) {

        String Texte = textmodcom.getText();
        
        CommentaireCRUD ps = new CommentaireCRUD();

        commentaire c = new commentaire( Texte );
        ps.Delete(c);
        modlabel.setText("Reclamation supprimée!");
        

    }

@FXML
    private void tablehandleButtonAction(MouseEvent event) {
        
        
        commentaire et = (commentaire) table.getSelectionModel().getSelectedItem();
        txtcom.setText(et.getTexte());
        setText(et.getDate());
    }
}
