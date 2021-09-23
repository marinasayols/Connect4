package connect4.models;

public class Turn {
    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private int activePlayer = 0;

    public Turn(Board board) {
        this.board = board;
    }

    public void next() {
        if (!this.board.isFinished()) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public Color getActiveColor() {
        return Color.get(this.activePlayer);
    }
}
