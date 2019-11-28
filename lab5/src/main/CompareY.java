import java.util.Comparator;

public class CompareY implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d first, Vector2d second) {
        if (first.y < second.y)
            return -1;
        else if (first.y == second.y)
            return (Integer.compare(first.x, second.x));
        else
            return 1;
    }
}
