package connect4;

import utils.Console;

import java.util.Scanner;

public class Player {

    private Board board;
    private Color color;

    Player(Color color, Board board) {
        this.color = color;
        this.board = board;
    }

    void putToken() {
        int column = 0;
        Error error;
        do {
            column = Console.getInstance().readInt(Message.GET_COLUMN.toString());
            error = this.getPutTokenError(column);
        } while (!error.isNull());
        this.board.putToken(column, this.color);
    }

    Error getPutTokenError(int column) {
        Error error = Error.NULL;
        if (column > Board.COLUMNS) {
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

    Color getColor() {
        return this.color;
    }
}
