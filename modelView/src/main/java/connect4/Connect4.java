package connect4;

import connect4.models.Board;
import connect4.models.Message;
import connect4.models.Turn;
import connect4.views.BoardView;

public class Connect4 {

    private final Board board;
    private final BoardView boardView;
    private final Turn turn;

    Connect4() {
        this.board = new Board();
        this.turn = new Turn(this.board);
        this.boardView = new BoardView(this.board);
    }

    private void play() {
        Message.TITLE.writeln();
        this.boardView.write(this.board);
        do {
            this.turn.play();
            this.boardView.write(this.board);
        } while (!this.board.isFinished());
        this.turn.writeWinner();
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
