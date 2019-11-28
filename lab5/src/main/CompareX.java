import java.util.Comparator;

public class CompareX implements Comparator<Vector2d> {
    @Override
    public int compare(Vector2d first, Vector2d second) {
        if (first.x < second.x)
            return -1;
        else if (first.x == second.x)
            return (Integer.compare(first.y, second.y));
        else
            return 1;
    }
}
