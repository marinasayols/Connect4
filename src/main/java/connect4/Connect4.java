package connect4;

public class Connect4 {

    private Board board;
    private Turn turn;

    Connect4() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play() {
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.turn.play();
            this.board.write();
        } while (!this.isFinished());
        this.turn.writeWinner();
    }

    private boolean isFinished() {
        return this.board.isFinished();
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
