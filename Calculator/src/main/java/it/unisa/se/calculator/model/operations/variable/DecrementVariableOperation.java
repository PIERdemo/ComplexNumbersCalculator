package it.unisa.se.calculator.model.operations.variable;

import it.unisa.se.calculator.model.ComplexNumber;
import it.unisa.se.calculator.model.ComplexNumberStack;
import it.unisa.se.calculator.model.VariablesMap;
import it.unisa.se.calculator.model.operations.Operation;
import static it.unisa.se.calculator.model.ComplexNumber.*;

public class DecrementVariableOperation extends Operation {




    @Override
    public void execute(VariablesMap variablesMap, String variable) {
        ComplexNumberStack complexNumberStack = ComplexNumberStack.getInstance();
        ComplexNumber valueNumber = variablesMap.get(variable);
        ComplexNumber topStackNumber = complexNumberStack.pop();

        ComplexNumber result = subtract(valueNumber,topStackNumber);
        variablesMap.put(variable,result);
    }
}
