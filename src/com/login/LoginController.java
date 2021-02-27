package com.login;

import com.dao.DaoImpl;
import com.model.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    public static String username1=null;
    DaoImpl dao = new DaoImpl();

    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private Label infoUsernameLBL;
    @FXML
    private Label infoPasswordLBL;
    @FXML
    private Button createAccountBtn;
    @FXML
    private Button loginBtn;
    @FXML
    private Label warningLBL;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void checkUsernameOnKeyReleased(KeyEvent event) {
        warningLBL.setText("");
        if (usernameTF.getText().trim().equalsIgnoreCase("")) {
            infoUsernameLBL.setVisible(true);
        } else {
            infoUsernameLBL.setVisible(false);
            if (usernameTF.getText().trim().contains(",")) {
                warningLBL.setText("Icerisinde Vergul Var");
                infoUsernameLBL.setVisible(true);
            }

        }
    }

    @FXML
    private void checkPasswordOnKeyReleased(KeyEvent event) {
        warningLBL.setText("");
        if (passwordTF.getText().trim().equalsIgnoreCase("")) {
            infoPasswordLBL.setVisible(true);
        } else {
            infoPasswordLBL.setVisible(false);
            if (passwordTF.getText().trim().contains(",")) {
                warningLBL.setText("Icerisinde Vergul Var");
                infoPasswordLBL.setVisible(true);
            }

        }
    }

    @FXML
    private void createAccountBtnOnAction(ActionEvent event) {
        try {
            Stage stage = new Stage();
            stage.setTitle("Create Account");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/createAccount/createAccount.fxml"));
            stage.getIcons().add(new Image("com/images/register.png"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cereds");
        }
    }

    @FXML
    private void loginBtnOnAction(ActionEvent event) {
        username1 = usernameTF.getText();
        String username = usernameTF.getText().trim();
        String password = passwordTF.getText().trim();
        if (username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
            warningLBL.setText("Xanalari Doldurun!");
        } else {
            Users user = dao.checkUser(username, password);
            if (user == null) {
                warningLBL.setText("Username ve ya Parol yanlisdir!");
            } else {
                try {
                   
                    Stage stage = new Stage();
                    stage.setTitle("Main Page");
                    stage.getIcons().add(new Image("/com/images/book.png"));
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/page/page.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    Stage oldStage =  (Stage) loginBtn.getScene().getWindow();
                    oldStage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
