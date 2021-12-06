package it.unisa.se.calculator.test;

import it.unisa.se.calculator.exception.CustomOperationDefined;
import it.unisa.se.calculator.exception.CustomOperationNotDefined;
import it.unisa.se.calculator.model.operations.customoperations.CustomOperationMap;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCustomOperationMap {
    private CustomOperationMap customOperationMap = CustomOperationMap.getInstance();

    @Test
    public void testAddCustomOperation(){
        customOperationMap.clear();
        String opA = "a";
        String operationsA = "2 * c";
        String opB = "b";
        String operationsB = "2 * c + d";
        String opC = "c";
        String operationsC = "3 / d";
        String opD = "d";
        String operationsD = "4 2 swap * /";
        customOperationMap.addCustomOperation(opD, operationsD);
        customOperationMap.addCustomOperation(opC, operationsC);
        customOperationMap.addCustomOperation(opA, operationsA);
        customOperationMap.addCustomOperation(opB, operationsB);

        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsA, new ArrayList<>(), new ArrayList<>(List.of("c"))), customOperationMap.get(opA));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsB, new ArrayList<>(), new ArrayList<>(List.of("c", "d"))), customOperationMap.get(opB));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsC, new ArrayList<>(List.of("a", "b")), new ArrayList<>(List.of("d"))), customOperationMap.get(opC));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsD, new ArrayList<>(List.of("c", "b")), new ArrayList<>()), customOperationMap.get(opD));

    }
    @Test(expected = CustomOperationDefined.class)
    public void testErrorAddCustomOperation(){
        String opD = "d";
        String operationsD = "4 2 swap * /";
        customOperationMap.addCustomOperation(opD, operationsD);
    }
    @Test
    public void testRemoveAtKey(){
        customOperationMap.clear();

        String opA = "a";
        String operationsA = "2 * c";
        String opB = "b";
        String operationsB = "2 * c + d";
        String opC = "c";
        String operationsC = "3 / d";
        String opD = "d";
        String operationsD = "4 2 swap * /";
        customOperationMap.addCustomOperation(opD, operationsD);
        customOperationMap.addCustomOperation(opC, operationsC);
        customOperationMap.addCustomOperation(opA, operationsA);
        customOperationMap.addCustomOperation(opB, operationsB);

        int initialSize = customOperationMap.size();
        customOperationMap.removeAtKey(opA);

        assertEquals(customOperationMap.size(), initialSize-1);

        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsB, new ArrayList<>(), new ArrayList<>(List.of("c", "d"))), customOperationMap.get(opB));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsC, new ArrayList<>(List.of("b")), new ArrayList<>(List.of("d"))), customOperationMap.get(opC));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsD, new ArrayList<>(List.of("c", "b")), new ArrayList<>()), customOperationMap.get(opD));

        customOperationMap.removeAtKey(opC);

        assertEquals(customOperationMap.size(), initialSize-3);

        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsD, new ArrayList<>(), new ArrayList<>()), customOperationMap.get(opD));
    }
    @Test(expected = CustomOperationNotDefined.class)
    public void testErrorRemoveAtKey(){
        customOperationMap.clear();

        String opA = "a";
        String operationsA = "2 * c";
        String opB = "b";
        String operationsB = "2 * c + d";
        String opC = "c";
        String operationsC = "3 / d";
        String opD = "d";
        String operationsD = "4 2 swap * /";
        customOperationMap.addCustomOperation(opD, operationsD);
        customOperationMap.addCustomOperation(opC, operationsC);
        customOperationMap.addCustomOperation(opA, operationsA);
        customOperationMap.addCustomOperation(opB, operationsB);

        customOperationMap.removeAtKey(opA);
        customOperationMap.removeAtKey(opA);

        customOperationMap.removeAtKey(opC);
        customOperationMap.removeAtKey(opC);


    }
    @Test
    public void testModifyOperation(){
        customOperationMap.clear();

        String opA = "a";
        String operationsA = "2 * c";
        String opB = "b";
        String operationsB = "2 * c + d";
        String opC = "c";
        String operationsC = "3 / d";
        String opD = "d";
        String operationsD = "4 2 swap * /";
        customOperationMap.addCustomOperation(opD, operationsD);
        customOperationMap.addCustomOperation(opC, operationsC);
        customOperationMap.addCustomOperation(opA, operationsA);
        customOperationMap.addCustomOperation(opB, operationsB);


        customOperationMap.modifyOperation(opD, "2 * a");

        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsA, new ArrayList<>(List.of("d")), new ArrayList<>(List.of("c"))), customOperationMap.get(opA));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsB, new ArrayList<>(), new ArrayList<>(List.of("c", "d"))), customOperationMap.get(opB));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsC, new ArrayList<>(List.of("a", "b")), new ArrayList<>(List.of("d"))), customOperationMap.get(opC));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>("2 * a", new ArrayList<>(List.of("c", "b")), new ArrayList<>(List.of("a"))), customOperationMap.get(opD));

        customOperationMap.modifyOperation(opB, "2 a c d c");

        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsA, new ArrayList<>(List.of("d", "b")), new ArrayList<>(List.of("c"))), customOperationMap.get(opA));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>("2 a c d c", new ArrayList<>(), new ArrayList<>(List.of("a", "c", "d"))), customOperationMap.get(opB));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>(operationsC, new ArrayList<>(List.of("a", "b")), new ArrayList<>(List.of("d"))), customOperationMap.get(opC));
        assertEquals(new MutableTriple<String, ArrayList<String>, ArrayList<String>>("2 * a", new ArrayList<>(List.of("c", "b")), new ArrayList<>(List.of("a"))), customOperationMap.get(opD));


    }
}
