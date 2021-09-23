package connect4;

enum Direction {
    VERTICAL(0,1),
    HORIZONTAL(1,0),
    DIAGONAL(1,1),
    INVERSE_DIAGONAL(1,-1);

    private final int xIncrement;
    private final int yIncrement;

    Direction(int xIncrement, int yIncrement){
        this.xIncrement = xIncrement;
        this.yIncrement = yIncrement;
    }

    int getX(){
        return this.xIncrement;
    }

    int getY(){
        return this.yIncrement;
    }
}
