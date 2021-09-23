package connect4;

import utils.ClosedInterval;
import utils.Console;

public class Player {

    private final Board board;
    private final Color color;

    Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    void putToken() {
        int column = 0;
        Error error;
        do {
            column = Console.getInstance().readInt(Message.GET_COLUMN.toString()) - 1;
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.board.putToken(column, this.color);
    }

    Error getPutTokenError(int column) {
        Error error = Error.NULL;
        if (!new ClosedInterval(0, Board.COLUMNS - 1).isIncluded(column)) {
            error = Error.WIDTH_OVERFLOW;
        } else if (this.board.isColumnFull(column)) {
            error = Error.FULL_COLUMN;
        }
        error.writeln();
        return error;
    }

    void writeWinner() {
        Message.WINNER.writeln(this.color);
    }
}
