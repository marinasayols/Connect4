package connect4;

public enum Error {
    WIDTH_OVERFLOW("Column value must be between 0 and 6"),
    FULL_COLUMN("This column is full"),
    WRONG_FORMAT("Wrong format! Enter an integer, please!"),
    NULL;

    private String message;

    Error(){
    }

    Error(String message){
        this.message = message;
    }

    void writeln(){
        if (!this.isNull()){
            System.out.println(this.message);
        }
    }

    boolean isNull(){
        return this == Error.NULL;
    }
}
