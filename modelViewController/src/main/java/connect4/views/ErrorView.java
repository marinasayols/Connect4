package connect4.views;

import connect4.models.Error;

public class ErrorView {

    void writeln(Error error) {
        if (!error.isNull()) {
            System.out.println(error.getMessage());
        }
    }
}
