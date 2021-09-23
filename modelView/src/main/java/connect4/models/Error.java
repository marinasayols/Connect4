package connect4.models;

public enum Error {
    WIDTH_OVERFLOW("Column value must be between 1 and 7"),
    FULL_COLUMN("This column is full"),
    NULL;

    private String message;

    Error() {
    }

    Error(String message) {
        this.message = message;
    }

    public boolean isNull() {
        return this == Error.NULL;
    }

    public String getMessage() {
        return this.message;
    }
}
