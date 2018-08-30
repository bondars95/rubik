import java.util.HashMap;

public enum Rotation {
    FRONT,
    BACK,
    RIGHT,
    LEFT,
    UP,
    DOWN,
    REVERSE_FRONT,
    REVERSE_BACK,
    REVERSE_RIGHT,
    REVERSE_LEFT,
    REVERSE_UP,
    REVERSE_DOWN,
    DOUBLE_FRONT,
    DOUBLE_BACK,
    DOUBLE_RIGHT,
    DOUBLE_LEFT,
    DOUBLE_UP,
    DOUBLE_DOWN;

    private static final HashMap<String, Rotation> mapping = new HashMap<String, Rotation>() {{
        put("F", FRONT);
        put("B", BACK);
        put("R", RIGHT);
        put("L", LEFT);
        put("U", UP);
        put("D", DOWN);
        put("F2", DOUBLE_FRONT);
        put("B2", DOUBLE_BACK);
        put("R2", DOUBLE_RIGHT);
        put("L2", DOUBLE_LEFT);
        put("U2", DOUBLE_UP);
        put("D2", DOUBLE_DOWN);
        put("F`", REVERSE_FRONT);
        put("B`", REVERSE_BACK);
        put("R`", REVERSE_RIGHT);
        put("L`", REVERSE_LEFT);
        put("U`", REVERSE_UP);
        put("D`", REVERSE_DOWN);
    }};

    public static Rotation fromValue(String notation) {
        return mapping.get(notation);
    }

    public int getTurns() {
        switch (this) {
            case FRONT:
            case BACK:
            case RIGHT:
            case LEFT:
            case UP:
            case DOWN:
                return 1;
            case DOUBLE_FRONT:
            case DOUBLE_BACK:
            case DOUBLE_RIGHT:
            case DOUBLE_LEFT:
            case DOUBLE_UP:
            case DOUBLE_DOWN:
                return 2;
            case REVERSE_FRONT:
            case REVERSE_BACK:
            case REVERSE_RIGHT:
            case REVERSE_LEFT:
            case REVERSE_UP:
            case REVERSE_DOWN:
                return 3;
            default:
                throw new RuntimeException("WTF");
        }
    }

    public char getNotation() {
        return this.toString().charAt(0);
    }
}
