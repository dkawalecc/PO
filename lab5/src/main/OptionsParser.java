import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] moves) {
        MoveDirection[] directions = new MoveDirection[moves.length];
        int i = 0;

        for (String move : moves) {
            switch (move) {
                case "f":
                case "forward":
                    directions[i] = MoveDirection.FORWARD;
                    i++;
                    break;
                case "b":
                case "backward":
                    directions[i] = MoveDirection.BACKWARD;
                    i++;
                    break;
                case "r":
                case "right":
                    directions[i] = MoveDirection.RIGHT;
                    i++;
                    break;
                case "l":
                case "left":
                    directions[i] = MoveDirection.LEFT;
                    i++;
                    break;
                default:
                    throw new IllegalArgumentException(move + "is not correct move specification.");
            }
        }

        return Arrays.copyOfRange(directions, 0, i);
    }
}