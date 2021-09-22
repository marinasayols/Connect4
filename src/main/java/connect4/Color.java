package connect4;

public enum Color {
    YELLOW("Y"),
    RED("R"),
    NULL(" ");

    private final String name;

    Color(String name){
      this.name = name;
    }

    static Color get(int ordinal){
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();
        return Color.values()[ordinal];
    }

    String getName(){
        return this.name;
    }
}
