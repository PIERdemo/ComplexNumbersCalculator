package it.unisa.se.calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 650);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        Alert alert = new Alert(Alert.AlertType.ERROR, "", new ButtonType("Return back"));
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.setTitle("Error Occurred");
            alert.setHeaderText("Error Occurred during the execution");

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            alert.setContentText(e.getCause().getCause().getMessage());
            alert.showAndWait();
        });
    }



    public static void main(String[] args) {
        launch();
    }
}