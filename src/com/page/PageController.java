package com.page;

import com.dao.DaoImpl;
import com.login.LoginController;
import com.model.Book;
import com.model.Users;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class PageController implements Initializable {

    DaoImpl dao = new DaoImpl();
    @FXML
    private TextField nameTF;
    @FXML
    private TextField authorTF;
    @FXML
    private TextField pageCountTF;
    @FXML
    private TextField AmountTF;
    @FXML
    private ComboBox<String> languageCombobox;
    @FXML
    private Button addLanguageBtn;
    @FXML
    private Button addThemeBtn;
    @FXML
    private ComboBox<String> themeCombobox;
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
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, Integer> idColumn;
    @FXML
    private TableColumn<Book, String> nameColumn;
    @FXML
    private TableColumn<Book, String> authorColumn;
    @FXML
    private TableColumn<Book, Integer> pageCountColumn;
    @FXML
    private TableColumn<Book, Double> amountColumn;
    @FXML
    private TableColumn<Book, String> languageColumn;
    @FXML
    private TableColumn<Book, String> themeColumn;
    @FXML
    private TableColumn<Book, String> statusColumn;
    @FXML
    private Label warningLBL;
    Users u = new Users();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadLanguageCB();
        loadThemeCB();
        tableView.setVisible(false);
        welcomeLBL.setText("Welcome, "+LoginController.username1);
        loadColumn();
        loadRows();
    }

    @FXML
    private void languageComboboxOnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void addLanguageBtnOnAction(ActionEvent event) {
        String newLanguage = JOptionPane.showInputDialog(null,"New Language");
        if (newLanguage.equalsIgnoreCase("")) {
            warningLBL.setText("Language is empty!");
        } else {
            if (languageCombobox.getItems().contains(newLanguage)) {
                warningLBL.setText("Not added! Language already exist");
            } else {
                if (languageCombobox.getItems().add(newLanguage)) {
                    warningLBL.setText("New Language successfully added!");
                } 
            }
        }
    }

    @FXML
    private void addThemeBtnOnAction(ActionEvent event) {
         String newTheme = JOptionPane.showInputDialog(null,"New Theme");
        if (newTheme.equalsIgnoreCase("")) {
            warningLBL.setText("Theme is empty!");
        } else {
            if (themeCombobox.getItems().contains(newTheme)) {
                warningLBL.setText("Not added! Theme already exist");
            } else {
                if (themeCombobox.getItems().add(newTheme)) {
                    warningLBL.setText("New Theme successfully added!");
                } 
            }
        }
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
        tableView.setVisible(true);

    }

    @FXML
    private void hideBtnOnAction(ActionEvent event) {
        tableView.setVisible(false);
    }

    @FXML
    private void logOutBtnOnAction(ActionEvent event) {
        try {
            int response = JOptionPane.showConfirmDialog(null, "Are you sure?");
            if (response == JOptionPane.YES_OPTION) {
                Stage stage = (Stage) logOutBtn.getScene().getWindow();
                stage.close();
                Stage stage1 = new Stage();
//                stage1.initModality(Modality.APPLICATION_MODAL);
                stage1.setTitle("Login");
                stage1.getIcons().add(new Image("/com/images/login.png"));
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/login/login.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                stage1.setScene(scene);
                stage1.show();
            } else {
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void tableViewOnMousePressed(MouseEvent event) {
    }

    private void loadLanguageCB() {
        List<String> language = new ArrayList<String>();
        languageCombobox.getItems().add("Azerbaycanca");
        languageCombobox.getItems().add("Rus");
        languageCombobox.getItems().add("Ingilisce");
        languageCombobox.getItems().add("Fransizca");
        languageCombobox.getItems().add("Almanca");
        languageCombobox.getItems().add("Turkce");
        languageCombobox.getSelectionModel().selectFirst();
    }

    private void loadThemeCB() {
        List<String> theme = new ArrayList<String>();
        themeCombobox.getItems().add("Roman");
        themeCombobox.getItems().add("Nagil");
        themeCombobox.getItems().add("Derslik");
        themeCombobox.getItems().add("Elmi");
        themeCombobox.getItems().add("Dedektiv");
        themeCombobox.getItems().add("Ozunu inkisaf");
        themeCombobox.getSelectionModel().selectFirst();
    }

    private void loadColumn() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        pageCountColumn.setCellValueFactory(new PropertyValueFactory<>("pageCount"));
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        themeColumn.setCellValueFactory(new PropertyValueFactory<>("theme"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadRows() {
        tableView.getItems().addAll(dao.getAllBooks());
    }

    @FXML
    private void saveBtnOnAction(ActionEvent event) {
        
    }

}
