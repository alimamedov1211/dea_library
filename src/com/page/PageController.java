
package com.page;

import com.model.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;


public class PageController implements Initializable {

    @FXML
    private TextField nameTF;
    @FXML
    private TextField authorTF;
    @FXML
    private TextField pageCountTF;
    @FXML
    private TextField AmountTF;
    @FXML
    private ComboBox<?> languageCombobox;
    @FXML
    private Button addLanguageBtn;
    @FXML
    private Button addThemeBtn;
    @FXML
    private ComboBox<?> themeCombobox;
    @FXML
    private Button saveBtn;
    @FXML
    private Button updateBtn;
    @FXML
    private TextField searchTF;
    @FXML
    private TextField minAmountTF;
    @FXML
    private TextField maxAmountTF;
    @FXML
    private Button amountFilterBtn;
    @FXML
    private Button filterPageCountBtn;
    @FXML
    private TextField maxPageCountTF;
    @FXML
    private TextField minPageCountTF;
    @FXML
    private Button clearAllFilterBtn;
    @FXML
    private Button buyBtn;
    @FXML
    private CheckBox soldCheckBox;
    @FXML
    private CheckBox unsoldCheckBox;
    @FXML
    private CheckBox allCheckBox;
    @FXML
    private Button statusFilterBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button showBtn;
    @FXML
    private Button hideBtn;
    @FXML
    private Label welcomeLBL;
    @FXML
    private Button logOutBtn;
    @FXML
    private TableView<?> tableView;
    @FXML
    private TableColumn<?, ?> idColumn;
    @FXML
    private TableColumn<?, ?> nameColumn;
    @FXML
    private TableColumn<?, ?> authorColumn;
    @FXML
    private TableColumn<?, ?> pageCountColumn;
    @FXML
    private TableColumn<?, ?> amountColumn;
    @FXML
    private TableColumn<?, ?> languageColumn;
    @FXML
    private TableColumn<?, ?> themeColumn;
    @FXML
    private TableColumn<?, ?> statusColumn;
    @FXML
    private Label warningLBL;
    
        Users user = new Users();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        welcomeLBL.setText("Welcome, ");
      
    }    

    @FXML
    private void languageComboboxOnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void addLanguageBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void addThemeBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void themeComboboxOnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void updateBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void searchTFOnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void amountFilterBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void filterPageCountBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void clearAllFilterBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void buyBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void statusFilterBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void deleteBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void showBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void hideBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void logOutBtnOnAction(ActionEvent event) {
    }

    @FXML
    private void tableViewOnMousePressed(MouseEvent event) {
    }
    
}
