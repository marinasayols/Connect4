package connect4.models;

public enum Message {
    TITLE("~~~ ~~~ CONNECT 4 ~~~ ~~~"),
    WINNER("#player wins!!"),
    GET_COLUMN("Indicate column: "),
    HORIZONTAL_LINE("-------------------------------"),
    VERTICAL_LINE(" | "),
    ;

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }

}
