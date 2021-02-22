package com.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainClass extends Application {

    @Override
    public void start(Stage s) throws Exception {
        try {
            s.setTitle("Login Page");
            s.getIcons().add(new Image("/com/images/login.png"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/login/login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            s.setScene(scene);
            s.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR!");
        }

    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
