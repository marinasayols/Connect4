package connect4;

public class Board {

    public static final int COLUMNS = 7;
    public static final int ROWS = 6;
    Color[][] cells;

    Board() {
        this.cells = new Color[Board.ROWS][Board.COLUMNS];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                cells[i][j] = Color.NULL;
            }
        }
    }

    void putToken(int column, Color color) {
        assert !isColumnFull(column);

        int i = 5;
        while (isCellFull(i, column)) {
            i--;
        }
        cells[i][column] = color;
    }

    boolean isCellFull(int row, int column) {
        return cells[row][column] != Color.NULL;
    }

    boolean isColumnFull(int column) {
        return this.isCellFull(0, column);
    }

    boolean isConnect4(Color color) {
        return false;
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
            Message.HORIZONTAL_LINE.writeln();
        }
    }
}
