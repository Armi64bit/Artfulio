/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tn.esprit.artfulio.entites.Collaboration;

/**
 * FXML Controller class
 *
 * @author lelou
 */
public class ImprimerCollaborationnController implements Initializable {

    @FXML
    private Label label_nom;

    @FXML
    private Label label_t;

    @FXML
    private Label label_type;

    @FXML
    private Label label_email;

    @FXML
    private Label label_date;

    @FXML
    private Label label_desc;

    @FXML
    private Button btn_impression;

    @FXML
    private Button btn_AnnerImpression;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void impression(ActionEvent event) {

        // Obtention de la fenêtre principale
        Stage primaryStage = (Stage) btn_impression.getScene().getWindow();

        // Obtention d'un objet PrinterJob pour gérer l'impression
        PrinterJob printerJob = PrinterJob.createPrinterJob();

        if (printerJob != null) {
            // Obtention de l'interface graphique à imprimer
            Scene scene = primaryStage.getScene();

            // Configuration des paramètres d'impression
            Printer printer = printerJob.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
            double scaleX = pageLayout.getPrintableWidth() / scene.getWidth();
            double scaleY = pageLayout.getPrintableHeight() / scene.getHeight();
            scene.getRoot().setScaleX(scaleX);
            scene.getRoot().setScaleY(scaleY);

            // Impression de l'interface graphique
            boolean success = printerJob.printPage(pageLayout, scene.getRoot());
            if (success) {
                printerJob.endJob();
            }
        }

        try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuCollaboration.fxml"));
            Parent root = loader.load();

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) btn_AnnerImpression.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btn_AnnerImpression(ActionEvent event) {

        Data.information("notification", "impression annuler");
        try {
            // Charger la scène2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuCollaboration.fxml"));
            Parent root = loader.load();

            // Afficher la scène2
            Scene scene = new Scene(root);
            Stage stage = (Stage) btn_AnnerImpression.getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void afficherModif(Collaboration c) {
        label_nom.setText(c.getTitre());
        label_t.setText(c.getType_collaboration());
        label_type.setText(c.getDescription());
        label_email.setText(c.getEmail_user());
        label_date.setText(c.getDate_sortie().toString());
        label_desc.setText(c.getDescription());
    }
}
