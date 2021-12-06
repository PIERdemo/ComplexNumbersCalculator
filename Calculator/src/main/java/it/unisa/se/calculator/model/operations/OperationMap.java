package it.unisa.se.calculator.model.operations;

import it.unisa.se.calculator.model.operations.arithmetic.*;
import it.unisa.se.calculator.model.operations.stack.*;
import it.unisa.se.calculator.model.operations.variable.*;
import java.util.HashMap;

public class OperationMap extends HashMap<String, Operation> {
    private static OperationMap instance = null;

    public OperationMap() {
        put("+",new SumOperation());
        put("-",new SubtractOperation());
        put("*",new MultiplyOperation());
        put("/",new DivideOperation());
        put("+-",new SignInversionOperation());
        put("sqrt",new SquareRootOperation());
        //advanced operations
        put("clear",new ClearOperation());
        put("over",new OverOperation());
        put("drop", new DropOperation());
        put("dup", new DupOperation());
        put("swap", new SwapOperation());
        //varaibles operations
        for(char  ch='a'; ch<='z';ch++){
            put("<"+ch, new LoadVariableOperation());
            put(">"+ch, new SaveVariableOperation());
            put("+"+ch, new IncrementVariableOperation());
            put("-"+ch, new DecrementVariableOperation());
        }


    }

    public static OperationMap getInstance() {
        if(instance == null){
            instance =  new OperationMap();
        }
        return instance;
    }
}
