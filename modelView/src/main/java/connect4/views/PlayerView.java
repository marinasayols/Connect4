package connect4.views;

import connect4.models.Error;
import connect4.models.*;
import utils.ClosedInterval;
import utils.Console;

public class PlayerView {
    private final Board board;
    private Turn turn;

    public PlayerView(Board board) {
        this.board = board;
        this.turn = new Turn(this.board);
    }

    public void play() {
        this.putToken();
        this.turn.next();
    }

    public void putToken() {
        int column = 0;
        Error error;
        do {
            column = Console.getInstance().readInt(Message.GET_COLUMN.toString()) - 1;
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.board.putToken(column, this.turn.getActiveColor());
    }

    public Error getPutTokenError(int column) {
        Error error = Error.NULL;
        if (!new ClosedInterval(0, Board.COLUMNS - 1).isIncluded(column)) {
            error = Error.WIDTH_OVERFLOW;
        } else if (this.board.isColumnFull(column)) {
            error = Error.FULL_COLUMN;
        }
        new ErrorView().writeln(error);
        return error;
    }

    public void writeWinner() {
        new MessageView().writeln(Message.WINNER,
                this.turn.getActiveColor().toString());
    }
}
