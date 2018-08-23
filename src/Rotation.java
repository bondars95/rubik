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

    private static final HashMap<String, Rotation> mapping = new HashMap<>() {{
        put("F", FRONT);
        put("B", BACK);
        put("R", RIGHT);
        put("L", LEFT);
        put("U", UP);
        put("D", DOWN);
        put("F2", REVERSE_FRONT);
        put("B2", REVERSE_BACK);
        put("R2", REVERSE_RIGHT);
        put("L2", REVERSE_LEFT);
        put("U2", REVERSE_UP);
        put("D2", REVERSE_DOWN);
        put("F`", DOUBLE_FRONT);
        put("B`", DOUBLE_BACK);
        put("R`", DOUBLE_RIGHT);
        put("L`", DOUBLE_LEFT);
        put("U`", DOUBLE_UP);
        put("D`", DOUBLE_DOWN);
    }};

    Rotation fromValue(String notation) {
        return mapping.get(notation);
    }
}
