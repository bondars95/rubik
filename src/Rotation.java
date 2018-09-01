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

    public static final HashMap<String, Rotation> mapping = new HashMap<String, Rotation>() {{
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

    private static final HashMap<Rotation, String> mapping2 = new HashMap<Rotation, String>() {{
        put(FRONT, "F");
        put(BACK, "B");
        put(RIGHT, "R");
        put(LEFT, "L");
        put(UP, "U");
        put(DOWN, "D");
        put(DOUBLE_FRONT, "F2");
        put(DOUBLE_BACK, "B2");
        put(DOUBLE_RIGHT, "R2");
        put(DOUBLE_LEFT, "L2");
        put(DOUBLE_UP, "U2");
        put(DOUBLE_DOWN, "D2");
        put(REVERSE_FRONT, "F`");
        put(REVERSE_BACK, "B`");
        put(REVERSE_RIGHT, "R`");
        put(REVERSE_LEFT, "L`");
        put(REVERSE_UP, "U`");
        put(REVERSE_DOWN, "D`");
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
        return mapping2.get(this).charAt(0);
    }
}
