package it.unisa.se.calculator;

import it.unisa.se.calculator.exception.InvalidCustomOperationException;
import it.unisa.se.calculator.model.*;
import it.unisa.se.calculator.model.observers.StackObserver;
import it.unisa.se.calculator.model.observers.StringTMapObserver;
import it.unisa.se.calculator.model.structures.ComplexNumberStack;
import it.unisa.se.calculator.model.structures.CustomOperationMap;
import it.unisa.se.calculator.model.structures.VariablesMap;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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
import javafx.stage.FileChooser;
import javafx.util.Callback;

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
    private Label errorLabel;
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
    private AnchorPane rootpane;
    @FXML
    private TextField contentFormula;

    @FXML
    private TextField nameFormula;

    @FXML
    private VBox formulaContentBox;

    private Calculator calculator = new Calculator();
    private CustomOperationMap customOperationMap;
    @FXML
    private Button swapButton;
    @FXML
    private Button addFormulaButton;
    @FXML
    private Button dropButton;
    @FXML
    private Button squareButton;
    @FXML
    private Button saveForumulaButton;
    @FXML
    private Button subtractButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button overButton;
    @FXML
    private Button modifyFormulaButton;
    @FXML
    private Button divideButton;
    @FXML
    private Button sumButton;
    @FXML
    private Button deleteFormulaButton;
    @FXML
    private Button dupButton;
    @FXML
    private Button inversionSignButton;
    @FXML
    private Button multiplyButton;
    @FXML
    private TableColumn formulaColumnName;
    @FXML
    private TableColumn formulaColumnContent;
    @FXML
    private TableView formulaTableView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        customOperationMap = calculator.getCustomOperationMap();
        ComplexNumberStack numberStack = calculator.getComplexNumberStack();
        VariablesMap variablesMap = calculator.getVariablesMap();

        StackObserver stackObserver = new StackObserver();
        numberStack.addListener(stackObserver);
        columnElements.setCellValueFactory(new PropertyValueFactory<>("complexNumberString"));
        tableElements.setItems(stackObserver);


        StringTMapObserver<ComplexNumber> stringTMapObserver = new StringTMapObserver<>();
        variablesMap.addListener(stringTMapObserver);
        columnNameVariables.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getKey()));
        columnValueVariables.setCellValueFactory(entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getValue().getComplexNumberString()));
        tableVariables.setItems(stringTMapObserver);

        StringTMapObserver<String> formulaMapObserver = new StringTMapObserver<>();
        customOperationMap.addListener(formulaMapObserver);
        formulaColumnName.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>) entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getKey()));
        formulaColumnContent.setCellValueFactory((Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>) entryStringCellDataFeatures -> new SimpleStringProperty(entryStringCellDataFeatures.getValue().getValue()));
        formulaTableView.setItems(formulaMapObserver);

        errorLabel.setVisible(false);
        tableVariables.setColumnResizePolicy(resizeFeatures -> false);
        initializeButtonsEvents();
        initializeEnterPressedOnTextField();

    }

    private void initializeEnterPressedOnTextField() {
        operationField.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                submitButton.fire();
            }
        });
    }

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



    @FXML
    public void onAddFormulaButtonClick(ActionEvent actionEvent) {
        calculator.customOperationInsertNameValidator(nameFormula.getText());
        formulaContentBox.setVisible(true);
    }

    @FXML
    public void onModifyFormulaButtonClick(ActionEvent actionEvent) {
        String nameFormulaText = nameFormula.getText();
        String formula = customOperationMap.get(nameFormulaText);
        if(formula == null)
            throw new InvalidCustomOperationException("Operation "+nameFormulaText+" does not exist ");
        contentFormula.setText(formula);
        formulaContentBox.setVisible(true);

    }

    @FXML
    public void onSaveFormulaButtonClick(ActionEvent actionEvent) {
        calculator.saveCustomOperation(nameFormula.getText(),contentFormula.getText());
        formulaContentBox.setVisible(false);
        nameFormula.setText("");
        contentFormula.setText("");
    }

    @FXML
    public void onDeleteFormulaButtonClick(ActionEvent actionEvent) {
        String nameFormulaText = nameFormula.getText();
        String formula = calculator.removeCustomOperation(nameFormulaText);
        if(formula == null)
            throw new InvalidCustomOperationException("Operation "+nameFormulaText+" does not exist ");
        nameFormula.setText("");
    }

    @FXML
    public void loadCustomOperations(ActionEvent actionEvent) {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", ".txt"));
        fc.setTitle("Open file");
        File file = fc.showOpenDialog(rootpane.getScene().getWindow());
        if(file!=null) {
            customOperationMap.loadFromFile(file);
        }
    }

    @FXML
    public void saveCustomOperation(ActionEvent actionEvent) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", ".txt"));
        fc.setTitle("Save as...");
        File file = fc.showSaveDialog(rootpane.getScene().getWindow());
        if(file!=null){
            customOperationMap.saveInFile(file);
        }
    }

    @FXML
    public void close(ActionEvent actionEvent) {
        Platform.exit();
    }
}

