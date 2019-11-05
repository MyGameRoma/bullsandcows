package bullsandcows;

public class TurnResult {
    private final int bulls;
    private final int cows;

    public TurnResult(int bulls, int cows) {
        this.bulls = bulls;
        this.cows = cows;
    }

    public int getBulls() {
        return bulls;
    }

    public int getCows() {
        return cows;
    }
}
