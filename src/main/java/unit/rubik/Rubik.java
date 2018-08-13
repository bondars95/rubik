package unit.rubik;

import java.util.List;

public class Rubik {
    private static final byte GREEN = 1;
    private static final byte YELLOW = 2;
    private static final byte ORANGE = 3;
    private static final byte RED = 4;
    private static final byte WHITE = 5;
    private static final byte BLUE = 6;

    private final byte[][] front = fillSideWith(GREEN);
    private final byte[][] back = fillSideWith(YELLOW);
    private final byte[][] left = fillSideWith(ORANGE);
    private final byte[][] right = fillSideWith(RED);
    private final byte[][] up = fillSideWith(WHITE);
    private final byte[][] down = fillSideWith(BLUE);

    public Rubik(final List<Rotation> rotations) {
    }

    /**
     * Just fills side this some color
     */
    private static byte[][] fillSideWith(byte color) {
        return new byte[][]{
                {color, color, color},
                {color, color, color},
                {color, color, color}
        };
    }
}
