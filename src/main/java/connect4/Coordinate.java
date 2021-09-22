package connect4;

import utils.ClosedInterval;

import java.util.ArrayList;

public class Coordinate {
    private final int row;
    private final int column;

    Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    ArrayList<Coordinate> getCellsInDirection(Direction direction) {
        ArrayList<Coordinate> cellsDirection = new ArrayList<Coordinate>();
        Coordinate current = this;
        do {
            cellsDirection.add(current);
            current = new Coordinate(current.getRow() + direction.getX(), current.getColumn() + direction.getY());
        } while (current.isValid() && cellsDirection.size() < Board.COLOR_GOAL);
        return cellsDirection;
    }

    boolean isValid() {
        return new ClosedInterval(0, Board.ROWS - 1).isIncluded(this.row)
                && new ClosedInterval(0, Board.COLUMNS - 1).isIncluded(this.column);
    }

    int getRow() {
        return this.row;
    }

    int getColumn() {
        return this.column;
    }
}
