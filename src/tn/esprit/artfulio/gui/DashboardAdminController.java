/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.artfulio.gui;

import tn.esprit.artfulio.utils.MyConnection;
import tn.esprit.artfulio.entites.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import tn.esprit.artfulio.services.UserService;

/**
 * FXML Controller class
 *
 * @author WINDOWS 10
 */
public class DashboardAdminController implements Initializable {

    @FXML
    private TableView<User> tableviewUser;
    @FXML
    private TableColumn<?, ?> idUser;
    @FXML
    private TableColumn<?, ?> Username;
    @FXML
    private TableColumn<?, ?> CinUser;
    @FXML
    private TableColumn<?, ?> AdresseUser;
    @FXML
    private TableColumn<?, ?> PasswordUser;
    @FXML
    private TableColumn<?, ?> EmailUser;
    @FXML
    private TableColumn<?, ?> RoleUser;
    @FXML
    private TableColumn<?, ?> ProUser;

    @FXML
    private TextField Recherche_User;
    private PreparedStatement prepare;
    private ResultSet result;
    User user = null;
    @FXML
    private Button btnSupp;
    @FXML
    private Button btnModifier;

    /**
     * Initializes the controller class.
     */
    private void GoPage(String Path, MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(Path));
        Parent parent = loader.load();
        Stage Window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(parent);
        Window.setScene(scene);
        Window.show();

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showUser();

    }

    public ObservableList<User> getUserList() {
        Connection cnx = MyConnection.getInstance().getConnection();

        ObservableList<User> UserList = FXCollections.observableArrayList();
        try {
            String query2 = "SELECT * FROM  user ";
            PreparedStatement smt = cnx.prepareStatement(query2);
            ResultSet rs = smt.executeQuery();
            while (rs.next()) {
                User user = new User(rs.getInt("id_user"), rs.getString("username"), rs.getString("cin_user"), rs.getString("adresse_user"), rs.getString("password_user"), rs.getString("email_user"), rs.getString("type_role"), rs.getString("is_pro"));
                UserList.add(user);
            }
            System.out.println(UserList);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return UserList;

    }

    @FXML
    public void showUser() {

        ObservableList<User> list = getUserList();
        idUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Username.setCellValueFactory(new PropertyValueFactory<>("username"));
        CinUser.setCellValueFactory(new PropertyValueFactory<>("cin_user"));
        AdresseUser.setCellValueFactory(new PropertyValueFactory<>("adresse_user"));
        PasswordUser.setCellValueFactory(new PropertyValueFactory<>("password_user"));
        EmailUser.setCellValueFactory(new PropertyValueFactory<>("email_user"));
        RoleUser.setCellValueFactory(new PropertyValueFactory<>("type_role"));
        ProUser.setCellValueFactory(new PropertyValueFactory<>("is_pro"));
        tableviewUser.setItems(list);

    }

    private void refresh() {
        ObservableList<User> list = getUserList();
        idUser.setCellValueFactory(new PropertyValueFactory<>("id_user"));
        Username.setCellValueFactory(new PropertyValueFactory<>("username"));
        CinUser.setCellValueFactory(new PropertyValueFactory<>("cin_user"));
        AdresseUser.setCellValueFactory(new PropertyValueFactory<>("adresse_user"));
        PasswordUser.setCellValueFactory(new PropertyValueFactory<>("password_user"));
        EmailUser.setCellValueFactory(new PropertyValueFactory<>("email_user"));
        RoleUser.setCellValueFactory(new PropertyValueFactory<>("type_role"));
        ProUser.setCellValueFactory(new PropertyValueFactory<>("is_pro"));
        tableviewUser.setItems(list);

    }

    @FXML
    private void SupprimerUser(MouseEvent event) throws SQLException {
        UserService u = new UserService();
        User user = (User) tableviewUser.getSelectionModel().getSelectedItem();
        u.supprimeruser(user);
        refresh();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Artfulio :: Error Message");
        alert.setHeaderText(null);
        alert.setContentText("Utilisateur supprimé");
        alert.showAndWait();
    }

    @FXML
    private void ModifierU(MouseEvent event) throws IOException {
        user = tableviewUser.getSelectionModel().getSelectedItem();
        GoPage("ModifierUser.fxml", event);
        FXMLLoader loader = new FXMLLoader();
       // ModifierUserController muc = loader.getController();
        //mrc.setUpdate(true);
        //muc.setTextFields(user);
        Parent parent = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
        showUser();
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
        GoPage("Login.fxml", event);
    }

    @FXML
    private void search(MouseEvent event) {
    }

}
