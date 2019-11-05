package bullsandcows;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static javafx.beans.binding.Bindings.*;
import static javafx.beans.binding.Bindings.isNotEmpty;
import static javafx.beans.binding.Bindings.when;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}