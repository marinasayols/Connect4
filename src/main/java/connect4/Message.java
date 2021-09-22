package connect4;

enum Message {
    TITLE("--- CONNECT 4 ---"),
    WINNER("#player wins!!"),
    GET_COLUMN("Indicate column: "),
    HORIZONTAL_LINE("-------------------------------"),
    VERTICAL_LINE(" | "),;

    private String message;

    Message(String message) {
        this.message = message;
    }

    void write() {
        System.out.print(this.message);
    }

    void writeln() {
        System.out.println(this.message);
    }

    void writeln(Color color) {
        assert this == Message.WINNER;

        System.out.println(
                this.message.replace(
                        "#player", "" + color.toString()));
    }

    @Override
    public String toString() {
        return message;
    }

}
