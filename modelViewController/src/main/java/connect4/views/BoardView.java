package connect4.views;

import connect4.models.Board;
import connect4.models.Coordinate;
import connect4.models.Message;
import utils.Console;

public class BoardView {

    private final Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void start() {
        new MessageView().writeln(Message.TITLE);
        this.write();
    }

    public void write() {
        new MessageView().writeln(Message.HORIZONTAL_LINE);
        for (int i = 0; i < Board.ROWS; i++) {
            new MessageView().write(Message.VERTICAL_LINE);
            for (int j = 0; j < Board.COLUMNS; j++) {
                Console.getInstance().write(this.board.getColor(new Coordinate(i, j)));
                new MessageView().write(Message.VERTICAL_LINE);
            }
            Console.getInstance().writeln();
        }
        new MessageView().writeln(Message.HORIZONTAL_LINE);
    }
}
