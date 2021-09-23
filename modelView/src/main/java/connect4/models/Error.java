package connect4.models;

public enum Error {
    WIDTH_OVERFLOW("Column value must be between 1 and 7"),
    FULL_COLUMN("This column is full"),
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
