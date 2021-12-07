package it.unisa.se.calculator;

import it.unisa.se.calculator.model.*;
import it.unisa.se.calculator.model.observers.StackObserver;
import it.unisa.se.calculator.model.observers.VariablesMapObserver;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

    @FXML
    private TextField operationField;
    @FXML
    private TableView<ComplexNumber> tableElements;
    @FXML
    private TableColumn<ComplexNumber, String> columnElements;
    @FXML
    private Label errorLabel;
    @FXML
    private VBox calculatorContainer;
    @FXML
    private TableView<Map.Entry<String, ComplexNumber>> tableVariables;
    @FXML
    private TableColumn<Map.Entry<String, ComplexNumber>, String> columnValueVariables;

    @FXML
    private TableColumn<Map.Entry<String, ComplexNumber>, String> columnNameVariables;


    private Calculator calculator = new Calculator();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ComplexNumberStack numberStack = calculator.getComplexNumberStack();
        VariablesMap variablesMap = calculator.getVariablesMap();

        StackObserver stackObserver = new StackObserver();
        numberStack.addListener(stackObserver);
        columnElements.setCellValueFactory(new PropertyValueFactory<>("complexNumberString"));
        tableElements.setItems(stackObserver);


        VariablesMapObserver variablesMapObserver = new VariablesMapObserver();
        variablesMap.addListener(variablesMapObserver);
        columnNameVariables.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getKey()));
        columnValueVariables.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getValue().getComplexNumberString()));
        tableVariables.setItems(variablesMapObserver);


        errorLabel.setVisible(false);
        tableVariables.setColumnResizePolicy(resizeFeatures -> false);
        initializeButtonsEvents();
        initializeEnterPressedOnTextField();

    }

    private void initializeEnterPressedOnTextField() {
        operationField.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                calculator.inputDispatcher(operationField.getText());
                errorLabel.setVisible(false);
                operationField.setText("");
            }
        });
    }

    private void initializeButtonsEvents() {
        calculatorContainer.getChildren().forEach(node -> {
            if (node instanceof GridPane) {
                ((GridPane) node).getChildren().forEach(node1 -> {
                    if (node1 instanceof Button) {
                        node1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                            errorLabel.setVisible(false);
                            operationField.setText("");
                            operationField.requestFocus();
                        });
                    }
                });
            }
            if (node instanceof VBox) {
                ((VBox) node).getChildren().forEach(node13 -> {
                    if (node13 instanceof HBox) {
                        ((HBox) node13).getChildren().forEach(node12 -> {
                            if (node12 instanceof Button) {
                                node12.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                                    errorLabel.setVisible(false);
                                    operationField.setText("");
                                    operationField.requestFocus();
                                });
                            }
                        });
                    }
                });
            }
        });
    }

    @FXML
    public void onInversionSignButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("+-");

    }

    @FXML
    public void onSquareButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("sqrt");

    }

    @FXML
    public void onSubmitButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher(operationField.getText());
        errorLabel.setVisible(false);
        operationField.setText("");
    }

    @FXML
    public void onSumButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("+");

    }

    @FXML
    public void onDivideButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("/");

    }

    @FXML
    public void onSubtractButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("-");

    }

    @FXML
    public void onMultiplyButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("*");

    }


    @FXML
    public void onDupButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("dup");

    }

    @FXML
    public void onClearButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("clear");

    }

    @FXML
    public void onOverButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("over");

    }

    @FXML
    public void onDropButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("drop");

    }

    @FXML
    public void onSwapButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("swap");

    }


}

