package connect4.models;

public class Turn {
    static final int NUMBER_PLAYERS = 2;
    private Board board;
    private Player[] players;
    private int activePlayer;

    public Turn(Board board) {
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    public void play() {
        this.players[this.activePlayer].putToken();
        if (!this.board.isFinished()) {
            this.activePlayer = (this.activePlayer + 1) % Turn.NUMBER_PLAYERS;
        }
    }

    public void writeWinner() {
        this.players[this.activePlayer].writeWinner();
    }
}
