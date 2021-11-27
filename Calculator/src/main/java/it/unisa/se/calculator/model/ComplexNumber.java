package it.unisa.se.calculator.model;

import java.security.InvalidParameterException;
import java.util.Objects;

/**
 * The class provides  a custom implementation of Complex Numbers.
 * This class includes also all the operations defined on complex numbers.
 */
public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber() {
    }

    /**
     * Constructor of a complex number.
     * @param real specifies the double value of number's real part
     * @param imaginary specifies the double value of number's imaginary part
     */
    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     *
     * @return a Double representing the imaginary part of the number.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     *
     * @return a Double representing the real part of the number.
     */
    public double getReal() {
        return real;
    }

    /**
     * Sets the value of real part to the specified parameter.
     * @param real a Double representing the real part of the number.
     */
    public void setReal(double real) {
        this.real = real;
    }
    /**
     * Sets the value of imaginary part to the specified parameter.
     * @param imaginary a Double representing the imaginary part of the number.
     */
    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComplexNumber that)) return false;
        return compareNumbers(that.getReal(), getReal()) == 0 && compareNumbers(that.getImaginary(), getImaginary()) == 0;
    }

    /**
     * Auxiliary method that adds a control on 0 values for imaginary part on both numbers.
     *
     * @param imaginary1 Double representing imaginary part of the first number.
     * @param imaginary2 Double representing imaginary part of the second number.
     * @return 0 if both parameters are 0, otherwise the value of the compare of both numbers.
     */
    private int compareNumbers(double imaginary1, double imaginary2){
        if(Math.abs(imaginary1) == 0.0 && Math.abs(imaginary2) == 0.0 )
            return 0;
        return Double.compare(imaginary1,imaginary2);
    }

    /**
     *
     * @return a string representing the number.
     */
    @Override
    public String toString() {

        String imaginarySign = "+";
        if(imaginary<0)
            imaginarySign = "";
        if (Math.abs(imaginary) ==0)
            return real +"";
        if (Math.abs(real) ==0)
            return imaginary +"j";
        return real + imaginarySign + imaginary + "j";
    }

    public String getComplexNumberString(){
        return toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReal(), getImaginary());
    }

    /**
     * Method that executes the base sum between two complex numbers.
     * @param complexNumber1 first operand
     * @param complexNumber2 second operand
     * @return a complex number representing the sum between the parameters.
     */
    public static ComplexNumber sum(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() + complexNumber2.getReal());
        result.setImaginary(complexNumber1.getImaginary() + complexNumber2.getImaginary());
        return result;
    }
    /**
     * Method that executes the base subtract between two complex numbers.
     * @param complexNumber1 first operand
     * @param complexNumber2 second operand
     * @return a complex number representing the subtraction between the parameters.
     */
    public static ComplexNumber subtract(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() - complexNumber2.getReal());
        result.setImaginary(complexNumber1.getImaginary() - complexNumber2.getImaginary());
        return result;
    }
    /**
     * Method that executes the base multiplication between two complex numbers.
     * @param complexNumber1 first operand
     * @param complexNumber2 second operand
     * @return a complex number representing the multiplication between the parameters.
     */
    public static ComplexNumber multiply(ComplexNumber complexNumber1, ComplexNumber complexNumber2) {
        ComplexNumber result = new ComplexNumber();
        result.setReal(complexNumber1.getReal() * complexNumber2.getReal() - complexNumber1.getImaginary() * complexNumber2.getImaginary());
        result.setImaginary(complexNumber1.getImaginary() * complexNumber2.getReal() + complexNumber2.getImaginary() * complexNumber1.getReal());
        return result;
    }
    /**
     * Method that executes the base division between two complex numbers.
     * @param complexNumber1 first operand
     * @param complexNumber2 second operand
     * @return a complex number representing the division between the parameters.
     */
    public static ComplexNumber divide(ComplexNumber complexNumber1, ComplexNumber complexNumber2){
        //check if operands are valid
        if(complexNumber2.getReal() == 0.0  && complexNumber2.getImaginary() == 0.0)
            throw new InvalidParameterException("Undefined division, second operand must be different from 0+0i");

        if(complexNumber1.getReal() == 0.0  && complexNumber1.getImaginary() == 0.0)
            return complexNumber1;


        double a = complexNumber1.getReal();
        double b = complexNumber1.getImaginary();
        double c= complexNumber2.getReal();
        double d = complexNumber2.getImaginary();
        return new ComplexNumber(((c*a)+(b*d))/(a*a + b*b), ((c*b)-(a*d))/(a*a + b*b));

    }

    /**
     * Method that executes the square root between two complex numbers.
     * @param complexNumber1 operand
     * @return the square root of the operand
     */
    public static ComplexNumber sqrt(ComplexNumber complexNumber1){
        double real = complexNumber1.getReal();
        double imaginary = complexNumber1.getImaginary();

        double module = Math.sqrt(real * real + imaginary* imaginary);

        double realRoot =  Math.sqrt((real + module) / 2);

        double imaginaryRoot = Math.sqrt(( module - real) / 2);
        if(imaginary<0) imaginaryRoot = imaginaryRoot*(-1);
        return new ComplexNumber(realRoot,imaginaryRoot);

    }
    /**
     * Method that executes the sign inversion between two complex numbers.
     * @param complexNumber1 operand
     * @return the sign inversion of the operand
     */
    public static ComplexNumber signInversion(ComplexNumber complexNumber1){
        double real = complexNumber1.getReal();
        double imaginary = complexNumber1.getImaginary();

        imaginary = (Math.abs(imaginary)==0)?imaginary:imaginary * (-1);
        real = (Math.abs(real)==0)?real:real * (-1);

        return new ComplexNumber(real, imaginary);
    }


}
