package com.createAccount;

import com.dao.DaoImpl;
import com.model.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateAccountController implements Initializable {
    DaoImpl dao = new DaoImpl();
    
    @FXML
    private Label warningLBL;
    @FXML
    private Button saveBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField nameTF;
    @FXML
    private TextField surnameTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField mailTF;
    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordTF;
    @FXML
    private PasswordField corfirmPasswordTF;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void saveBtnOnAction(ActionEvent event) {
        String name = nameTF.getText().trim();
        String surname = surnameTF.getText().trim();
        String username = usernameTF.getText().trim();
        String password = passwordTF.getText().trim();
        String confirmPassword = corfirmPasswordTF.getText().trim();
        String mail = mailTF.getText().trim();
        String address = addressTF.getText().trim();
        
        if(name.equalsIgnoreCase("")||surname.equalsIgnoreCase("")||
        username.equalsIgnoreCase("")||password.equalsIgnoreCase("")||confirmPassword.equalsIgnoreCase("")||mail.equalsIgnoreCase("")||address.equalsIgnoreCase("")){
            warningLBL.setText("Zehmet olmasa butun xanalari doldurun!");
        }
        else{
            if(password.equalsIgnoreCase(confirmPassword)){
                if(dao.checkUserbyUsername(username)){
                    warningLBL.setText("Username istifade olunur");
                }
                else{
                    Users user = new Users(0, name, surname, username, password, mail, address);
                    boolean isAdded = dao.createAccount(user);
                    if(isAdded){
                        warningLBL.setText("Account ugurla yarandi");
                        Stage oldStage = (Stage) saveBtn.getScene().getWindow();
                        oldStage.close();
                    }else{
                        warningLBL.setText("Account yaradilmadi");
                    }
                }
            }
            else{
                warningLBL.setText("Parollar uygundeyil");
            }
        }
    }

    @FXML
    private void cancelBtnOnAction(ActionEvent event) {
        nameTF.setText("");
        surnameTF.setText("");
        usernameTF.setText("");
        passwordTF.setText("");
        corfirmPasswordTF.setText("");
        mailTF.setText("");
        addressTF.setText("");
    }

}
