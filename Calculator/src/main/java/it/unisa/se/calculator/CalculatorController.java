package it.unisa.se.calculator;

import it.unisa.se.calculator.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;


public class CalculatorController implements Initializable {

    @FXML
    private Button subtractButton;
    @FXML
    private TextField operationField;
    @FXML
    private Button submitButton;
    @FXML
    private Button divideButton;
    @FXML
    private TableView<ComplexNumber> tableElements;
    @FXML
    private Button sumButton;
    @FXML
    private TableColumn<ComplexNumber,String> columnElements;
    @FXML
    private Button inversionSignButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private Button squareButton;

    ComplexNumberStack numberStack=ComplexNumberStack.getInstance();
    Calculator calculator = new Calculator();



    private ObservableList<ComplexNumber> elements;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        elements = FXCollections.observableArrayList(numberStack.topKElements(12));
        columnElements.setCellValueFactory(new PropertyValueFactory<>("Elements"));
        tableElements.setItems(elements);
    }

    @FXML
    public void onInversionSignButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("+-");
        operationField.setText(numberStack.peek().toString());

    }

    @FXML
    public void onSquareButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("sqrt");
        operationField.setText(numberStack.peek().toString());

    }

    @FXML
    public void onSubmitButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher(operationField.getText());
        operationField.setText(numberStack.peek().toString());
    }

    @FXML
    public void onSumButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("+");
        operationField.setText(numberStack.peek().toString());

    }

    @FXML
    public void onDivideButtonCLick(ActionEvent actionEvent) {
        calculator.inputDispatcher("/");
        operationField.setText(numberStack.peek().toString());

    }

    @FXML
    public void onSubtractButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("-");
        operationField.setText(numberStack.peek().toString());

    }

    @FXML
    public void onMultiplyButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("*");
        operationField.setText(numberStack.peek().toString());

    }


}

