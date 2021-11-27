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
import java.util.ListIterator;
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
    @FXML
    private Label errorLabel;

    private ComplexNumberStack numberStack=ComplexNumberStack.getInstance();
    private Calculator calculator = new Calculator();
    private ObservableList<ComplexNumber> stackView=FXCollections.observableArrayList(numberStack);



    private void updatestackView(){
        stackView.clear();
        int i = 0;

        ListIterator<ComplexNumber> complexNumberListIterator = numberStack.listIterator(numberStack.size());
        while (complexNumberListIterator.hasPrevious() && i<12) {
            stackView.add(complexNumberListIterator.previous());
            ++i;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabel.setVisible(false);

        columnElements.setCellValueFactory(new PropertyValueFactory<>("complexNumberString"));
        columnElements.setPrefWidth(12);
        tableElements.setItems(stackView);

    }

    @FXML
    public void onInversionSignButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("+-");
        updatestackView();
    }

    @FXML
    public void onSquareButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("sqrt");
        updatestackView();
    }

    @FXML
    public void onSubmitButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher(operationField.getText());
        updatestackView();
    }

    @FXML
    public void onSumButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("+");
        updatestackView();
    }

    @FXML
    public void onDivideButtonCLick(ActionEvent actionEvent) {
        calculator.inputDispatcher("/");
        updatestackView();
    }

    @FXML
    public void onSubtractButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("-");
        updatestackView();
    }

    @FXML
    public void onMultiplyButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("*");
        updatestackView();
    }


}

