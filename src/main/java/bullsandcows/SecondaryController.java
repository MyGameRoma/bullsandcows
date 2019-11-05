package bullsandcows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static javafx.beans.binding.Bindings.*;
import static javafx.beans.binding.Bindings.isNotEmpty;
import static javafx.beans.binding.Bindings.when;

public class SecondaryController {

    public TextField myTextField;
    public Label myTextLabel;

    public void initialize() {
        myTextLabel.textProperty()
                .bind(when(isNotEmpty(myTextField.textProperty()))
                        .then(concat(
                                "Hello, ",
                                myTextField.textProperty(),
                                "!"))
                        .otherwise("Enter your name!")
                );
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}