package connect4.views;

import connect4.models.Message;
import utils.Console;

public class MessageView {

    public void write(Message message) {
        Console.getInstance().write(message.toString());
    }

    public void writeln(Message message) {
        Console.getInstance().writeln(message.toString());
    }

    public void writeln(Message message, String player) {
        assert message == Message.WINNER;

        Console.getInstance().writeln(message.toString().replace("#player", "" + player));
    }
}
