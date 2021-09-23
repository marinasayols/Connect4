package connect4;

import utils.Console;

enum Message {
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

    void write() {
        Console.getInstance().write(this.message);
    }

    void writeln() {
        Console.getInstance().writeln(this.message);
    }

    void writeln(Color color) {
        assert this == Message.WINNER;

        Console.getInstance().writeln(this.message.replace("#player", "" + color.toString()));
    }

    @Override
    public String toString() {
        return message;
    }

}
