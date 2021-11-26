module it.unisa.se.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;


    opens it.unisa.se.calculator to javafx.graphics, javafx.fxml, javafx.base;
    exports it.unisa.se.calculator;
    exports it.unisa.se.calculator.test;
    exports it.unisa.se.calculator.model;
    exports it.unisa.se.calculator.exception;
}