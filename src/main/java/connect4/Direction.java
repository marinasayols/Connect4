package connect4;

enum Direction {
    VERTICAL(0,1),
    HORIZONTAL(0,1),
    DIAGONAL(1,1),
    INVERSE_DIAGONAL(1,-1);

    private int xIncrement;
    private int yIncrement;

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
