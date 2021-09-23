package connect4.views;

import connect4.models.Board;
import connect4.models.Error;
import connect4.models.Message;
import connect4.models.Turn;
import utils.ClosedInterval;
import utils.Console;

public class PlayerView {
    private final Board board;
    private final Turn turn;

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
            new ErrorView().writeln(error);
        } while (!error.isNull());
        this.board.putToken(column, this.turn.getActiveColor());
    }

    public Error getPutTokenError(int column) {
        if (!new ClosedInterval(0, Board.COLUMNS - 1).isIncluded(column)) {
            return Error.WIDTH_OVERFLOW;
        }
        if (this.board.isColumnFull(column)) {
            return Error.FULL_COLUMN;
        }
        return Error.NULL;
    }

    public void writeWinner() {
        new MessageView().writeln(Message.WINNER,
                this.turn.getActiveColor().toString());
    }
}
