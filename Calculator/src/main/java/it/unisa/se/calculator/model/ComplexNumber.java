package it.unisa.se.calculator.model;

import java.util.Objects;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber() {
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber)) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.getReal(), getReal()) == 0 && Double.compare(that.getImaginary(), getImaginary()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    /*static methods*/
    public static ComplexNumber sum(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() + complexNumber2.getReal());
        result.setImaginary(complexNumber1.getImaginary() + complexNumber2.getImaginary());
        return result;
    }

    public static ComplexNumber subtract(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() - complexNumber2.getReal());
        result.setImaginary(complexNumber1.getImaginary() - complexNumber2.getImaginary());
        return result;
    }

    public static ComplexNumber multiply(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() * complexNumber2.getReal() - complexNumber1.getImaginary() * complexNumber2.getImaginary());
        result.setImaginary(complexNumber1.getImaginary() * complexNumber2.getReal() + complexNumber2.getImaginary() * complexNumber1.getReal());
        return result;
    }


}
