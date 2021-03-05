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

    private Users user1;
    DaoImpl dao = new DaoImpl();

    Integer selectedId = 0; //id get ucun

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadLanguageCB();
        loadThemeCB();
        tableView.setVisible(false);

        loadColumn();
        loadRows();
    }

    public void setUser(Users selectedUser) {
        this.user1 = selectedUser;
    }

    @FXML
    private void languageComboboxOnKeyReleased(KeyEvent event) {
    }

    @FXML
    private void addLanguageBtnOnAction(ActionEvent event) {
        String newLanguage = JOptionPane.showInputDialog(null, "New Language");
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
        String newTheme = JOptionPane.showInputDialog(null, "New Theme");
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
        warningLBL.setText("");
        if (nameTF.getText().equalsIgnoreCase("") || authorTF.getText().equalsIgnoreCase("") || pageCountTF.getText().equalsIgnoreCase("") || AmountTF.getText().equalsIgnoreCase("")) {
            warningLBL.setText("Zehmet olmasa butun xanalari doldurun!");
        } else {
            try {
                Book updateBook = new Book();
                updateBook.setId(selectedId);
                updateBook.setName(nameTF.getText());
                updateBook.setAuthor(authorTF.getText());
                updateBook.setAmount(Double.parseDouble(AmountTF.getText()));
                updateBook.setPageCount(Integer.parseInt(pageCountTF.getText()));
                updateBook.setTheme(themeCombobox.getSelectionModel().getSelectedItem());
                updateBook.setLanguage(languageCombobox.getSelectionModel().getSelectedItem());
                if (dao.updateBook(updateBook)) {
                    warningLBL.setText("Ugurla deyisildi!");
                    refresh();
                } else {
                    warningLBL.setText("Deyismek alinmadi!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    private void searchTFOnKeyReleased(KeyEvent event) {
        String keyword = searchTF.getText().toUpperCase().trim();
        if (keyword.equalsIgnoreCase("")) {
            refresh();
        } else {
            List resultList = dao.searchBook(keyword);
            tableView.getItems().clear();
            tableView.getItems().addAll(resultList);
        }
    }

    @FXML
    private void amountFilterBtnOnAction(ActionEvent event) {
        warningLBL.setText("");
        if (minAmountTF.getText().trim().equalsIgnoreCase("") || maxAmountTF.getText().trim().equalsIgnoreCase("")) {
            warningLBL.setText("Zehmet olmasa butun xanalari doldurun!");
        } else {
            Double minAmount = Double.parseDouble(minAmountTF.getText().trim());
            Double maxAmount = Double.parseDouble(maxAmountTF.getText().trim());
            List<Book> result = dao.filterBookByAmount(minAmount, maxAmount);
            tableView.getItems().clear();
            tableView.getItems().addAll(result);
        }
    }

    @FXML
    private void filterPageCountBtnOnAction(ActionEvent event) {
        warningLBL.setText("");
        if (minPageCountTF.getText().trim().equalsIgnoreCase("") || maxPageCountTF.getText().trim().equalsIgnoreCase("")) {
            warningLBL.setText("Zehmet olmasa butun xanalari doldurun!");
        } else {
            Double min = Double.parseDouble(minPageCountTF.getText().trim());
            Double max = Double.parseDouble(maxPageCountTF.getText().trim());
            List<Book> result = dao.filterBookByPageCount(min, max);
            tableView.getItems().clear();
            tableView.getItems().addAll(result);
        }
    }

    @FXML
    private void clearAllFilterBtnOnAction(ActionEvent event) {
        searchTF.setText("");
        minAmountTF.setText("");
        maxAmountTF.setText("");
        minPageCountTF.setText("");
        maxPageCountTF.setText("");
        refresh();
    }

    @FXML
    private void buyBtnOnAction(ActionEvent event) {
        boolean isUpdated = dao.updateBookByStatus(selectedId);
        if (isUpdated) {
            refresh();
            warningLBL.setText("Status Ugurla deyisildi!");
        } else {
            warningLBL.setText("Ugursuz oldu!");
        }
    }

    @FXML
    private void statusFilterBtnOnAction(ActionEvent event) {
        if (soldCheckBox.isSelected()) {
            List<Book> soldBook = dao.filterBookByStatus("Sold");
            tableView.getItems().clear();
            tableView.getItems().addAll(soldBook);
        } else if (unsoldCheckBox.isSelected()) {

            List<Book> unSoldBook = dao.filterBookByStatus("Not Sold");
            tableView.getItems().clear();
            tableView.getItems().addAll(unSoldBook);
        } else if (allCheckBox.isSelected()) {
            refresh();
        }
    }

    @FXML
    private void deleteBtnOnAction(ActionEvent event) {
        if (dao.deleteBook(selectedId)) {
            refresh();
            warningLBL.setText("Ugurla silindi!");
        } else {
            warningLBL.setText("Silinme prosesi ugursuz oldu!");
        }
    }

    @FXML
    private void showBtnOnAction(ActionEvent event) {
        tableView.setVisible(true);
        welcomeLBL.setText("Welcome, " + user1.getName() + " " + user1.getSurname());

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
        Book book = tableView.getSelectionModel().getSelectedItem();
        nameTF.setText(book.getName());
        authorTF.setText(book.getAuthor());
        pageCountTF.setText(book.getPageCount() + "");
        AmountTF.setText(book.getAmount() + "");
        languageCombobox.getSelectionModel().select(book.getLanguage());
        themeCombobox.getSelectionModel().select(book.getTheme());
        selectedId = book.getId();
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

    //table refreshing for table (savebtn)
    public void refresh() {
        tableView.getItems().clear();
        tableView.getItems().addAll(dao.getAllBooks());
    }

    @FXML
    private void saveBtnOnAction(ActionEvent event) {
        warningLBL.setText("");
        if (nameTF.getText().equalsIgnoreCase("") || authorTF.getText().equalsIgnoreCase("") || pageCountTF.getText().equalsIgnoreCase("") || AmountTF.getText().equalsIgnoreCase("")) {
            warningLBL.setText("Zehmet olmasa butun xanalari doldurun!");
        } else {
            try {
                Book newBook = new Book();
                newBook.setName(nameTF.getText());
                newBook.setTheme(themeCombobox.getSelectionModel().getSelectedItem());
                newBook.setAuthor(authorTF.getText());
                newBook.setPageCount(Integer.parseInt(pageCountTF.getText()));
                newBook.setAmount(Double.parseDouble(AmountTF.getText()));
                newBook.setLanguage(languageCombobox.getSelectionModel().getSelectedItem());
                if (dao.addBook(newBook)) {
                    warningLBL.setText("Yeni kitab ugurla elave olundu!");
                    refresh();
                } else {
                    warningLBL.setText("Elave olunmadi!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
