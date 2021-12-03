package it.unisa.se.calculator.interfaces;

import it.unisa.se.calculator.model.ComplexNumber;

import java.util.List;

public interface Observer {
    void update(List<ComplexNumber> list);
}
