package bullsandcows;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class PrimaryController {
    public Spinner<Integer> num1;
    public Spinner<Integer> num2;
    public Spinner<Integer> num3;
    public Spinner<Integer> num4;
    public TableView<Turn> turns;
    public Button goButton;
    private int turnCounter;
    private List<Integer> myNumbers;

    public void initialize() {
        generateRandomNumber();
        goButton.disableProperty().bind(
                Bindings.createBooleanBinding(this::invalidNumbers,
                        num1.valueProperty(),
                        num2.valueProperty(),
                        num3.valueProperty(),
                        num4.valueProperty())
        );
    }

    private void generateRandomNumber() {
        var rand = new Random();
        myNumbers = new ArrayList<>();
        while (myNumbers.size() < 4) {
            int num = rand.nextInt(10);
            if (!myNumbers.contains(num)) {
                myNumbers.add(num);
            }
        }
        // TODO remove this line after debug
        System.out.println(myNumbers);
    }

    private Boolean invalidNumbers() {
        var numSet = new HashSet<Integer>();
        numSet.add(num1.getValue());
        numSet.add(num2.getValue());
        numSet.add(num3.getValue());
        numSet.add(num4.getValue());
        return numSet.size() < 4;
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    public void doTurn(ActionEvent actionEvent) throws IOException {
        turnCounter++;
        int n1 = num1.getValue();
        int n2 = num2.getValue();
        int n3 = num3.getValue();
        int n4 = num4.getValue();
        String guess = "" + n1 + n2 + n3 + n4;

        Turn turn = new Turn();
        turn.setGuess(guess);
        turn.setTurnNr(turnCounter);

        turns.getItems().add(turn);

        turns.sort();

        System.out.println("Button pressed! " + guess);
    }
}
