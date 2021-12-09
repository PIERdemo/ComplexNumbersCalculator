package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.structures.VariablesMap;
import it.unisa.se.calculator.model.operations.arithmetic.*;
import it.unisa.se.calculator.model.operations.positional.*;
import it.unisa.se.calculator.model.operations.trigonometric.ArgOperation;
import it.unisa.se.calculator.model.operations.trigonometric.ExpOperation;
import it.unisa.se.calculator.model.operations.trigonometric.ModOperation;
import it.unisa.se.calculator.model.operations.variable.*;

import java.util.HashMap;

/**
 * The class has a map that stores as in a dictionary references to object implementing Operation interface.
 * This class provides a Map implementation that associates an Operation with a string, to identifies it.
 * */
public class OperationMap extends HashMap<String, Operation> {
    private static OperationMap instance = null;
    private VariablesMap variablesMap;

    /**
     * This constructor allows all possible values associated with an Operation to be defined.
     * @param variablesMap is passed to some Operations to enable its execution
     */
    private OperationMap(VariablesMap variablesMap) {
        this.variablesMap = variablesMap;

        put("+", new SumOperation());
        put("-", new SubtractOperation());
        put("*", new MultiplyOperation());
        put("/", new DivideOperation());
        put("+-", new SignInversionOperation());
        put("sqrt", new SquareRootOperation());
        //positional operations
        put("clear", new ClearOperation());
        put("over", new OverOperation());
        put("drop", new DropOperation());
        put("dup", new DupOperation());
        put("swap", new SwapOperation());
        //advanced operations
        put("mod", new ModOperation());
        put("arg", new ArgOperation());
        put("exp", new ExpOperation());
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


    /**
     * This method provide an instance of a OperationMap.
     * @param variablesMap the instance that is provided
     * @return if the instance is null, it will be initialized as a new OperationMap with variablesMap param
     */
    public static OperationMap getInstance(VariablesMap variablesMap) {
        if (instance == null)
            instance = new OperationMap(variablesMap);
        return instance;
    }

}
