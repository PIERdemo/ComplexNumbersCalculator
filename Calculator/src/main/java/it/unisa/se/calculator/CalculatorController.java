package it.unisa.se.calculator;

import it.unisa.se.calculator.exception.InvalidCustomOperationException;
import it.unisa.se.calculator.model.Calculator;
import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.observers.StackObserver;
import it.unisa.se.calculator.model.observers.StringTMapObserver;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.structures.CustomOperationMap;
import it.unisa.se.calculator.model.structures.VariablesMap;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
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
    private VBox calculatorContainer;
    @FXML
    private TableView<Map.Entry<String, ComplexNumber>> tableVariables;
    @FXML
    private TableColumn<Map.Entry<String, ComplexNumber>, String> columnValueVariables;
    @FXML
    private TableColumn<Map.Entry<String, ComplexNumber>, String> columnNameVariables;
    @FXML
    private Button submitButton;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField contentFormula;
    @FXML
    private TextField nameFormula;
    @FXML
    private VBox formulaContentBox;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> formulaColumnName;
    @FXML
    private TableColumn<Map.Entry<String, String>, String> formulaColumnContent;
    @FXML
    private TableView<Map.Entry<String, String>> formulaTableView;



    private final Calculator calculator = new Calculator();
    private CustomOperationMap customOperationMap;

    /**
     * This method binds the data structures in the model with their representation in the GUI,
     * this is done using the Observer pattern. It also provides initialization of graphical elements.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


        customOperationMap = calculator.getCustomOperationMap();
        ComplexNumberStack numberStack = calculator.getComplexNumberStack();
        VariablesMap variablesMap = calculator.getVariablesMap();

        StackObserver stackObserver = new StackObserver();
        numberStack.addListener(stackObserver);
        columnElements.setCellValueFactory(complexNumberStringCellDataFeatures -> new SimpleStringProperty(complexNumberStringCellDataFeatures.getValue().toString()));
        tableElements.setItems(stackObserver);


        StringTMapObserver<ComplexNumber> variablesMapObserver = new StringTMapObserver<>();
        variablesMap.addListener(variablesMapObserver);
        columnNameVariables.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getKey()));
        columnValueVariables.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getValue().toString()));
        tableVariables.setItems(variablesMapObserver);


        StringTMapObserver<String> formulaMapObserver = new StringTMapObserver<>();
        customOperationMap.addListener(formulaMapObserver);
        formulaColumnName.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getKey()));
        formulaColumnContent.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getValue()));
        formulaTableView.setItems(formulaMapObserver);


        tableVariables.setColumnResizePolicy(resizeFeatures -> false);
        formulaTableView.setColumnResizePolicy(resizeFeatures -> false);
        Platform.runLater(() -> operationField.requestFocus());
        initializeButtonsEvents();
        initializeEnterPressedOnTextField();

    }

    /**
     * This method implements the sumbit functionality when the enter button is pressed on the keyboard
     */
    private void initializeEnterPressedOnTextField() {
        operationField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                submitButton.fire();
            }
        });
    }

    /**
     *
     * This method implements, after the execution of any operation,
     * through one of the buttons of the GUI, to put in focus the text box and also resets its content
     */
    private void initializeButtonsEvents() {
        calculatorContainer.getChildren().forEach(node -> {
            if (node instanceof GridPane) {
                ((GridPane) node).getChildren().forEach(node1 -> {
                    if (node1 instanceof Button) {
                        node1.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
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
    public void onInversionSignButtonClick() {
        calculator.inputDispatcher("+-");

    }

    @FXML
    public void onSquareButtonClick() {
        calculator.inputDispatcher("sqrt");

    }

    @FXML
    public void onSubmitButtonClick() {
        calculator.inputDispatcher(operationField.getText());
        operationField.setText("");
        operationField.requestFocus();
    }

    @FXML
    public void onSumButtonClick() {
        calculator.inputDispatcher("+");

    }

    @FXML
    public void onDivideButtonClick() {
        calculator.inputDispatcher("/");

    }

    @FXML
    public void onSubtractButtonClick() {
        calculator.inputDispatcher("-");

    }

    @FXML
    public void onMultiplyButtonClick() {
        calculator.inputDispatcher("*");

    }


    @FXML
    public void onDupButtonClick() {
        calculator.inputDispatcher("dup");

    }

    @FXML
    public void onClearButtonClick() {
        calculator.inputDispatcher("clear");

    }

    @FXML
    public void onOverButtonClick() {
        calculator.inputDispatcher("over");

    }

    @FXML
    public void onDropButtonClick() {
        calculator.inputDispatcher("drop");

    }

    @FXML
    public void onSwapButtonClick() {
        calculator.inputDispatcher("swap");

    }



    @FXML
    public void onAddFormulaButtonClick() {
        calculator.customOperationInsertNameValidator(nameFormula.getText());
        formulaContentBox.setVisible(true);
    }

    /**
     * This method, after checking if the formula locally in the calculator, allows the calculator to modify it,
     * making its content appear as well
     */
    @FXML
    public void onModifyFormulaButtonClick() {
        String nameFormulaText = nameFormula.getText();
        String formula = customOperationMap.get(nameFormulaText);
        if(formula == null)
            throw new InvalidCustomOperationException("Operation "+nameFormulaText+" does not exist ");
        contentFormula.setText(formula);
        formulaContentBox.setVisible(true);

    }

    /**
     * This method, takes the values of the fields related to the formula name and to its associated operations, and instructs the Calculator object
     * to save the same operation, after that it resets all the fields related to the formula management
     */
    @FXML
    public void onSaveFormulaButtonClick() {
        calculator.saveCustomOperation(nameFormula.getText(),contentFormula.getText());
        formulaContentBox.setVisible(false);
        nameFormula.setText("");
        contentFormula.setText("");
    }

    /**
     * This method gets the name of the operation to delete and executes the deletion, in case this operation does not exist it throws an exception,
     * finally it resets the content of the text field dedicated to the insertion of formulas
     */
    @FXML
    public void onDeleteFormulaButtonClick() {
        String nameFormulaText = nameFormula.getText();
        String formula = calculator.removeCustomOperation(nameFormulaText);
        if(formula == null)
            throw new InvalidCustomOperationException("Operation "+nameFormulaText+" does not exist ");
        nameFormula.setText("");
    }

    /**
     * This method implements access to the operating system's FileChooser,
     * in order to load a list of user-defined operations into a text file.
     */
    @FXML
    public void loadCustomOperations() {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", ".txt"));
        fc.setTitle("Open file");
        File file = fc.showOpenDialog(anchorPane.getScene().getWindow());
        if(file!=null) {
            customOperationMap.loadFromFile(file);
        }
    }

    /**
     * This method implements the access to the FileChooser
     * of the operating system, in order to save the list of
     * user-defined operations in a text file.
     */
    @FXML
    public void saveCustomOperation() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", ".txt"));
        fc.setTitle("Save as...");
        File file = fc.showSaveDialog(anchorPane.getScene().getWindow());
        if(file!=null){
            customOperationMap.saveInFile(file);
        }
    }


}

