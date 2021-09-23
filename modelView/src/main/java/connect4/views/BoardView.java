package connect4.views;

import connect4.models.Board;
import connect4.models.Message;
import utils.Console;

public class BoardView {

    Board board;

    public BoardView(Board board){
        this.board = board;
    }

    public void write(Board board) {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Board.ROWS; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Board.COLUMNS; j++) {
                Console.getInstance().write(board.cells[i][j].getName());
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
