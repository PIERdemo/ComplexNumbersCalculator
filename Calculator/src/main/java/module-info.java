module com.example.calculator {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;

    opens it.unisa.se.calculator to javafx.fxml;
    exports it.unisa.se.calculator;
}