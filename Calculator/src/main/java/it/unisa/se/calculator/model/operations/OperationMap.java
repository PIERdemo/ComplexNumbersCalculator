package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.structures.VariablesMap;
import it.unisa.se.calculator.model.operations.arithmetic.*;
import it.unisa.se.calculator.model.operations.positional.*;
import it.unisa.se.calculator.model.operations.variable.*;

import java.util.HashMap;

public class OperationMap extends HashMap<String, Operation> {
    private static OperationMap instance = null;
    private VariablesMap variablesMap;

    private OperationMap(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;

        put("+", new SumOperation());
        put("-", new SubtractOperation());
        put("*", new MultiplyOperation());
        put("/", new DivideOperation());
        put("+-", new SignInversionOperation());
        put("sqrt", new SquareRootOperation());
        //advanced operations
        put("clear", new ClearOperation());
        put("over", new OverOperation());
        put("drop", new DropOperation());
        put("dup", new DupOperation());
        put("swap", new SwapOperation());
        //variables operations
        for (char ch = 'a'; ch <= 'z'; ch++) {
            put("<" + ch, new LoadVariableOperation(ch, this.variablesMap));
            put(">" + ch, new SaveVariableOperation(ch, this.variablesMap));
            put("+" + ch, new IncrementVariableOperation(ch, this.variablesMap));
            put("-" + ch, new DecrementVariableOperation(ch, this.variablesMap));
        }
        put("save", new SaveVariablesOperation(this.variablesMap));
        put("restore", new RestoreVariablesOperation(this.variablesMap));
    }

    public VariablesMap getVariablesMap() {
        return variablesMap;
    }

    public void setVariablesMap(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;
    }

    public static OperationMap getInstance(VariablesMap variablesMap) {
        if (instance == null)
            instance = new OperationMap(variablesMap);
        return instance;
    }



}
