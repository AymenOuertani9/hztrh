/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pidev.entities.fos_user;
import pidev.service.fos_userService;
import pitry.PiTry;

/**
 * FXML Controller class
 *
 * @author ouertani
 */
public class ProfileController implements Initializable {

    @FXML
    private AnchorPane profilecontent;
    @FXML
    private Text txtusername;
    @FXML
    private Text txtemail;
    @FXML
    private Button gochangeUsername;
    @FXML
    private AnchorPane profilecontent1;
    @FXML
    private JFXButton btnlogout;
    @FXML
    private JFXButton btnDesactiver1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        fos_user user = new fos_user();
        fos_userService us = new fos_userService();
        try {
            user = us.getUserById(PiTry.user_id);
            txtusername.setText(user.getUsername());
            txtemail.setText(user.getEmail());
            System.out.println(user.getLast_login());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(user.getLast_login()));
        } catch (SQLException ex) {
            Logger.getLogger(ProfileController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void gochangeUsername(ActionEvent event) throws IOException {
        profilecontent1.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("/gui/username.fxml"));
        profilecontent1.getChildren().add(parent);
        profilecontent1.toFront();
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        //Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        //alert.setTitle("Logout");
        //alert.setContentText("Voulez-vous vraiment vous deconnecter maintenant?");

        //alert.showAndWait();
        //System.out.println(alert.getResult());
        //System.out.println(alert.getResult().toString());
        //System.out.println(alert.showAndWait());
        PiTry.fos_user = null;
        Parent root = FXMLLoader.load(getClass().getResource("/gui/Login.fxml"));

        Scene scene = new Scene(root);
        Stage stage = (Stage) btnlogout.getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    private void mesevent(ActionEvent event) throws IOException {
        profilecontent1.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource(""));
        profilecontent1.getChildren().add(parent);
        profilecontent1.toFront();
    }

}
