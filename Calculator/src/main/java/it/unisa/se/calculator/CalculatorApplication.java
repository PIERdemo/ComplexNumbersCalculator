package it.unisa.se.calculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class CalculatorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorApplication.class.getResource("calculator-view.fxml"));

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> System.out.println("CIAO"));


        Scene scene = new Scene(fxmlLoader.load(), 480, 320);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
        Label errorLabel = (Label) scene.lookup("#errorLabel");

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> errorLabel.setVisible(true));



    }



    public static void main(String[] args) {
        launch();
    }
}