package it.unisa.se.calculator;

import it.unisa.se.calculator.model.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ListIterator;
import java.util.ResourceBundle;
import java.util.function.Consumer;


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
    @FXML
    private VBox calculatorContainer;




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
        inizializeButtonsEvents();
        initializeEnterPressedOnTextField();


    }

    private void initializeEnterPressedOnTextField() {
        operationField.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                calculator.inputDispatcher(operationField.getText());
                updatestackView();
                operationField.setText("");
            }
        });
    }

    private void inizializeButtonsEvents() {
        calculatorContainer.getChildren().forEach(node -> {
            if (node instanceof GridPane) {
                ((GridPane) node).getChildren().forEach(node1 -> {
                    if (node1 instanceof Button) {
                        node1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
                            errorLabel.setVisible(false);
                            operationField.requestFocus();
                        });
                    }
                });
            }
            if (node instanceof HBox) {
                ((HBox) node).getChildren().forEach(node12 -> {
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

