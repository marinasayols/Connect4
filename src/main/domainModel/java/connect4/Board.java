package connect4;

import java.util.ArrayList;

public class Board {

    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    public static final int COLOR_GOAL = 4;
    Color[][] cells;

    Board() {
        this.cells = new Color[Board.ROWS][Board.COLUMNS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                this.cells[i][j] = Color.NULL;
            }
        }
    }

    void putToken(int column, Color color) {
        assert !this.isColumnFull(column);

        this.cells[this.findEmptyRow(column)][column] = color;
    }

    int findEmptyRow(int column) {
        int row = Board.ROWS - 1;
        while (this.isCellFull(new Coordinate(row, column))) {
            row--;
        }
        return row;
    }

    boolean isCellFull(Coordinate coordinate) {
        return this.cells[coordinate.getRow()][coordinate.getColumn()] != Color.NULL;
    }

    boolean isColumnFull(int column) {
        return this.isCellFull(new Coordinate(0, column));
    }

    boolean isFinished() {
        return this.isFull() || this.isConnect4();
    }

    boolean isFull() {
        for (int i = 0; i < Board.COLUMNS; i++) {
            if (!this.isColumnFull(i)) {
                return false;
            }
        }
        return true;
    }

    boolean isConnect4() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                for (Direction direction : Direction.values()) {
                    if (this.hasFourConsecutive(coordinate.getCellsInDirection(direction))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean hasFourConsecutive(ArrayList<Coordinate> cellsDirection) {
        Color color = this.cells[cellsDirection.get(0).getRow()][cellsDirection.get(0).getColumn()];
        int counter = 0;
        for (int i = 0; i < cellsDirection.size(); i++) {
            if (color == Color.NULL){
                return false;
            }
            if (color == this.cells[cellsDirection.get(i).getRow()][cellsDirection.get(i).getColumn()]) {
                counter++;
            }
        }
        return counter == Board.COLOR_GOAL;
    }

    void write() {
        Message.HORIZONTAL_LINE.writeln();
        for (int i = 0; i < Board.ROWS; i++) {
            Message.VERTICAL_LINE.write();
            for (int j = 0; j < Board.COLUMNS; j++) {
                System.out.print(cells[i][j].getName());
                Message.VERTICAL_LINE.write();
            }
            System.out.println();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
