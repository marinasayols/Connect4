package connect4;

import connect4.models.Board;
import connect4.views.BoardView;
import connect4.views.PlayerView;

public class Connect4 {

    private final Board board;

    Connect4() {
        this.board = new Board();
    }

    private void play() {
        BoardView boardView = new BoardView(this.board);
        boardView.start();
        PlayerView playerView = new PlayerView(this.board);
        do {
            playerView.play();
            boardView.write();
        } while (!this.board.isFinished());
        playerView.writeWinner();
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
