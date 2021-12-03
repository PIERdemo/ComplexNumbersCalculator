package it.unisa.se.calculator;

import it.unisa.se.calculator.model.Calculator;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

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

    @FXML
    private Button overButton;
    @FXML
    private Button swapButton;
    @FXML
    private Button dropButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button dupButton;
    @FXML
    private TabPane TabPane;
    @FXML
    private TextField OperationName;
    @FXML
    private Button submitOperationButton;
    @FXML
    private TextField OperationFormula;
    @FXML
    private VBox calculatorContainer;
    @FXML
    private TableColumn columnNameVariables;
    @FXML
    private TableColumn columnValueVariables;
    @FXML
    private AnchorPane calculatorPane;
    @FXML
    private TableView tableVariables;
    @FXML
    private SplitPane splitPane;


    private void updatestackView(){
        stackView.clear();
        int i = 0;

        ListIterator<ComplexNumber> complexNumberListIterator = numberStack.listIterator(numberStack.size());
        while (complexNumberListIterator.hasPrevious() && i<20) {
            stackView.add(complexNumberListIterator.previous());
            ++i;
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        errorLabel.setVisible(false);

        columnElements.setCellValueFactory(new PropertyValueFactory<>("complexNumberString"));


        tableElements.setItems(stackView);
        initializeButtonsEvents();
        initializeEnterPressedOnTextField();

        tableVariables.setColumnResizePolicy(new Callback<TableView.ResizeFeatures, Boolean>() {
            @Override
            public Boolean call(TableView.ResizeFeatures resizeFeatures) {
                return false;
            }
        });
    }

    private void initializeEnterPressedOnTextField() {
        operationField.setOnKeyPressed(ke -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                calculator.inputDispatcher(operationField.getText());
                updatestackView();
                errorLabel.setVisible(false);
                operationField.setText("");
                errorLabel.setVisible(false);
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


    @FXML
    public void onDupButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("dup");
        updatestackView();
    }

    @FXML
    public void onClearButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("clear");
        updatestackView();
    }

    @FXML
    public void onOverButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("over");
        updatestackView();
    }

    @FXML
    public void onDropButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("drop");
        updatestackView();
    }

    @FXML
    public void onSwapButtonClick(ActionEvent actionEvent) {
        calculator.inputDispatcher("swap");
        updatestackView();
    }

    @FXML
    public void onSubmitOperationButtonClick(ActionEvent actionEvent) {

    }
}

