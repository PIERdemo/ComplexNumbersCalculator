package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;

/**
 * The class implements the interface Operation
 * It provides a method that takes the
 * top element from the stack and add it to the value of a variable
 * */
public class IncrementVariableOperation implements Operation {
private String character ;
private VariablesMap variablesMap;

    public IncrementVariableOperation(char character, VariablesMap variablesMap) {
        this.character = String.valueOf(character);
        this.variablesMap = variablesMap;
    }

    /**
     * The function execute is used to take the
     * top element from the stack and add it to the value of a variable
     */
    @Override
    public void  execute(){
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber complexNumberVariable = variablesMap.get(character);
        ComplexNumber complexNumber = complexNumberStack.pop();

        variablesMap.put(character,ComplexNumber.sum(complexNumberVariable,complexNumber));
    }
}
