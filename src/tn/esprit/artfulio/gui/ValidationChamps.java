/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



/**
 *
 * @author lelou
 */


public class ValidationChamps {
    public static boolean estValide(String champ) {
        // Vérifie si le champ est vide
        if (champ.isEmpty()) {
            return false;
        }

        return true;
    }

    public static boolean estDateValide(LocalDate date) {
        // Vérifie si la date est supérieure ou égale à 2023
        LocalDate dateMin = LocalDate.of(2023, 1, 1);
        if (date.isBefore(dateMin)) {
            return false;
        }

        return true;
    }

    public static boolean validerChamps(TextField champ, Label champErreur) {
        String texte = champ.getText();

        // Vérifie si le champ est valide
        if (estValide(texte)) {
            champErreur.setText("");
            return true;
        } else {
            champErreur.setText("ce champ ne doit pas etre vide");
            return false;
        }
    }

    public static boolean validerChamps(TextArea champ, Label champErreur) {
        String texte = champ.getText();

        // Vérifie si le champ est valide
        if (estValide(texte)) {
            champErreur.setText("");
            return true;
        } else {
            champErreur.setText("ce champ ne doit pas etre vide ou contenir des caracteres spéciaux");
            return false;
        }
    }

    public static boolean validerDate(DatePicker date, Label champErreur) {
        LocalDate dateSortie = date.getValue();

        // Vérifie si la date est valide
        if (dateSortie != null && estDateValide(dateSortie)) {
            champErreur.setText("");
            return true;
        } else {
            champErreur.setText("La date doit être supérieure ou égale à 2023.");
            return false;
        }
    }

    public static boolean validerType(ChoiceBox<String> choix, Label champErreur) {
        String type = choix.getValue();

        // Vérifie si le champ est valide
        if (estValide(type)) {
            champErreur.setText("");
            return true;
        } else {
            champErreur.setText("veuillez choisir un type");
            return false;
        }
    }

}

