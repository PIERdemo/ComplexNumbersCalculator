package it.unisa.se.calculator.test;

import it.unisa.se.calculator.model.structures.CustomOperationMap;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class TestCustomOperationMap {
    private CustomOperationMap customOperationMap = new CustomOperationMap();


    @Test
    public void testLoadFromFile(){
        String op1 = "op1";
        String operation1 = "2 3";
        String op2 = "op2";
        String operation2 = "9 sqrt";
        String op3 = "op3";
        String operation3 = "25 dup clear";

        customOperationMap.loadFromFile(new File("src/main/java/it/unisa/se/calculator/test/Files/TestLoad"));

        assertEquals(operation1,customOperationMap.get(op1));
        assertEquals(operation2,customOperationMap.get(op2));
        assertEquals(operation3,customOperationMap.get(op3));

    }

    @Test
    public void testSaveInFile(){
        String op1 = "op1";
        String operation1 = "2 3 +";
        String op2 = "op2";
        String operation2 = "9 sqrt";
        String op3 = "op3";
        String operation3 = "25 dup clear";


        customOperationMap.put(op1,operation1);
        customOperationMap.put(op2,operation2);
        customOperationMap.put(op3,operation3);

        customOperationMap.saveInFile(new File("src/main/java/it/unisa/se/calculator/test/Files/TestSave"));
        customOperationMap.loadFromFile(new File("src/main/java/it/unisa/se/calculator/test/Files/TestSave"));

        assertEquals(operation1,customOperationMap.get(op1));
        assertEquals(operation2,customOperationMap.get(op2));
        assertEquals(operation3,customOperationMap.get(op3));

    }






}
