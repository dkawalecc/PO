public class OptionsParser {
    public static MoveDirection[] parse(String[] moves) {
        MoveDirection[] directions = new MoveDirection[moves.length];


        for (int i = 0; i < moves.length; i++) {
            switch (moves[i]) {
                case "f":
                case "forward":
                    directions[i] = MoveDirection.FORWARD;

                    break;
                case "b":
                case "backward":
                    directions[i] = MoveDirection.BACKWARD;

                    break;
                case "r":
                case "right":
                    directions[i] = MoveDirection.RIGHT;

                    break;
                case "l":
                case "left":
                    directions[i] = MoveDirection.LEFT;

                    break;
                default:
                    throw new IllegalArgumentException(moves[i] + " is not legal move specification.");
            }
        }

        return directions;
    }
}