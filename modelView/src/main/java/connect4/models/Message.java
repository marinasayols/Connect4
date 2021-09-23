package connect4.models;

import utils.Console;

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

    public void write() {
        Console.getInstance().write(this.message);
    }

    public void writeln() {
        Console.getInstance().writeln(this.message);
    }

    public void writeln(Color color) {
        assert this == Message.WINNER;

        Console.getInstance().writeln(this.message.replace("#player", "" + color.toString()));
    }

    @Override
    public String toString() {
        return message;
    }

}
